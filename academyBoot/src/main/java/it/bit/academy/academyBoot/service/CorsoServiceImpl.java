package it.bit.academy.academyBoot.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
import it.bit.academy.academyBoot.exceptions.IscrizioneNotFoundException;
import it.bit.academy.academyBoot.model.Aula;
import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.model.Lezione;
import it.bit.academy.academyBoot.model.Modulo;
import it.bit.academy.academyBoot.model.PreferenzeCalendario;
import it.bit.academy.academyBoot.model.Scheduler;
import it.bit.academy.academyBoot.model.SlotOrarioLezione;
import it.bit.academy.academyBoot.repository.AulaDao;
import it.bit.academy.academyBoot.repository.CourseDao;
import it.bit.academy.academyBoot.repository.LezioneDao;
import it.bit.academy.academyBoot.repository.StudentDao;

@Service
public class CorsoServiceImpl implements CorsoService {
	private CourseDao courseDao;
	private LezioneDao lezioneDao;
	private AulaDao aulaDao;
	private StudentDao studentDao;
	
	
	@Autowired
	public CorsoServiceImpl(CourseDao courseDao, LezioneDao lezioneDao, AulaDao aulaDao, StudentDao studentDao) {
		this.courseDao = courseDao;
		this.lezioneDao = lezioneDao;
		this.aulaDao = aulaDao;
		this.studentDao = studentDao;
	}
	@Override
	@Transactional
	public List<Course> findAll() {
	
		return courseDao.findAll();
	}

	@Override
	public Course findById(int id) throws CourseNotFoundException {
		return courseDao.findById(id).orElseThrow(()->new CourseNotFoundException("corso non trovato"));
	}

	@Override
	public Course add(Course t) {
		Course c=courseDao.save(t);
		creaCalendario(c);
		return c;
	}

	private void creaCalendario(Course c) {
		LocalDateTime ldti, ldtf;
		List<Modulo> listaModuli=c.getListaModulo();
		
		for (Modulo modulo : listaModuli) {
			Scheduler scheduler = new Scheduler(modulo);
			Map<LocalDate, SlotOrarioLezione> provv = scheduler.generateSchedule(LocalDate.now()); //serve una variabile in modulo per scegliere la data inizio desiderata
			for (LocalDate data : provv.keySet()) {
				ldti = LocalDateTime.of(data, provv.get(data).getOraInizio());
				ldtf = LocalDateTime.of(data, provv.get(data).getOraFine());
				
				//Controllo se ci sono lezioni che collidono nell'intervallo interessato
				List<Lezione> collisioni = lezioneDao.findAllLessonsBetween(ldti, ldtf, modulo.getAulaPreferita().getNomeAula());
				//Se lo slot è libero, salvo la lezione
				if(collisioni.isEmpty()) {
					lezioneDao.save(new Lezione(modulo, ldti, ldtf, modulo.getAulaPreferita()));
				}else { //altrimenti cerco un'altra aula libera
					for(Aula altraAula : aulaDao.findAll()) {
						collisioni=lezioneDao.findAllLessonsBetween(ldti, ldtf, altraAula.getNomeAula());
						if(collisioni.isEmpty() && altraAula.getCapienzaMax() >= modulo.getCorso().getMaxIscritti()) {
							lezioneDao.save(new Lezione(modulo, ldti, ldtf, altraAula));
							break;
						}else {
							//devo cambiare giorno
							
						}
					}
					
				}
				
			}
		}
		
	}
	@Override
	public void remove(int id) throws  CourseNotFoundException{
		Course c=courseDao.findById(id).orElseThrow(()->new CourseNotFoundException("corso non trovato"));
		courseDao.delete(c);
		
	}

	@Override
	public void update(Course t) {
		
		courseDao.save(t);
	}

}
