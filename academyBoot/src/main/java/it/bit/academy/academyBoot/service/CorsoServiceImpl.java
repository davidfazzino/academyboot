package it.bit.academy.academyBoot.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bit.academy.academyBoot.dto.CourseDto;
import it.bit.academy.academyBoot.dto.ModuloDto;
import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
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

@Service
public class CorsoServiceImpl implements CorsoService {
	private CourseDao courseDao;
	private LezioneDao lezioneDao;
	private AulaDao aulaDao;	
	
	@Autowired
	public CorsoServiceImpl(CourseDao courseDao, LezioneDao lezioneDao, AulaDao aulaDao) {
		this.courseDao = courseDao;
		this.lezioneDao = lezioneDao;
		this.aulaDao = aulaDao;
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
	public Course add(CourseDto t) throws CourseNotFoundException {
		final Course c = initCourse(t);
		List<Modulo> lm = t.getListaModuli().stream()
			.map(m -> {
				Modulo mod = new Modulo(c, null, m.getNome(), m.getDescrizione(), m.getNumeroOre(), m.getDataDesiderata(),
					aulaDao.findById(m.getAulaPreferita()).get());
				List<PreferenzeCalendario> lpc = m.getListaPreferenze().stream()
						.map(f -> new PreferenzeCalendario(mod, f.getGiorno(), f.getOraInizio(), f.getOraFine()))
						.collect(Collectors.toList());
				mod.setListaPreferenzaCalendario(lpc);
				return mod;
				})
			.collect(Collectors.toList());
		
		c.setListaModulo(lm);
		Course def = courseDao.save(c);
		creaCalendarioCorso(def);
		return def;
	}
	
	private Course initCourse(CourseDto dt) {
		Course c = new Course(dt.getNome(), dt.getMateria(), dt.getMaxIscritti(),
				dt.getCategoria(), dt.getDurataCorso(), dt.getDataInizio(),
				dt.getOrarioMinimo());		
		return c;
	}

	private void creaCalendario2(Course c) {
		LocalDateTime ldti, ldtf;
		List<Modulo> listaModuli=c.getListaModulo().stream().sorted((x1, x2) -> x1.getId() - x2.getId()).collect(Collectors.toList());
		
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
	
	//DA RISOLVERE: le ore nel DB sono arretrate di un'ora
	private void creaCalendarioCorso(Course c) {
		List<Modulo> listaModuli = c.getListaModulo().stream().sorted((x1, x2) -> x1.getId() - x2.getId())
				.collect(Collectors.toList());
		LocalDateTime ldti, ldtf;
		for (Modulo modulo : listaModuli) {
			Map<DayOfWeek, List<SlotOrarioLezione>> mappaOrari = modulo.getListaPreferenzaCalendario().stream()
					.map(SlotOrarioLezione::new)
					.collect(Collectors.groupingBy(SlotOrarioLezione::getGiorno, TreeMap::new, Collectors.toList()));

			LocalDate startDate = modulo.getDataDesiderata();
			int monteOre = 0;
			DayOfWeek firstDay = startDate.getDayOfWeek(); //giorno della settimana della data desiderata
			DayOfWeek startDay = null; //giorno della settimana effettivo
			int lastDayOfWeek = mappaOrari.keySet().stream().sorted((x1, x2) -> x2.getValue() - x1.getValue())
					.findFirst().get().getValue();

			while (monteOre < modulo.getNumeroOre()) {
				for (DayOfWeek day : mappaOrari.keySet()) {
					//entro solo se la data di calendario che sto scorrendo corrisponde a una preferenza del modulo
					if (day.compareTo(firstDay) >= 0 && monteOre < modulo.getNumeroOre()) { 
						startDay = day;
						startDate = startDate.with(TemporalAdjusters.nextOrSame(startDay));

						for (SlotOrarioLezione sol : mappaOrari.get(startDay)) {
							//creo le possibili date del calendario
							ldti = LocalDateTime.of(startDate, sol.getOraInizio());
							ldtf = LocalDateTime.of(startDate, sol.getOraFine());
							System.out.println(startDate + " " + ldti + " " + sol.getOraInizio());
							
							// Controllo se ci sono lezioni che collidono nell'intervallo interessato
							List<Lezione> collisioni = lezioneDao.findAllLessonsBetween(ldti, ldtf,
									modulo.getAulaPreferita().getNomeAula());
							// Se lo slot è libero, salvo la lezione
							if (collisioni.isEmpty() && modulo.getAulaPreferita().getCapienzaMax() >= modulo.getCorso().getMaxIscritti()) {
								System.out.println(ldti + " " + ldtf);
								lezioneDao.save(new Lezione(modulo, ldti, ldtf, modulo.getAulaPreferita()));
								monteOre += ChronoUnit.HOURS.between(sol.getOraInizio(), sol.getOraFine());
							} else { // altrimenti cerco un'altra aula libera
								for (Aula altraAula : aulaDao.findAll()) {
									collisioni = lezioneDao.findAllLessonsBetween(ldti, ldtf, altraAula.getNomeAula());
									if (collisioni.isEmpty()
											&& altraAula.getCapienzaMax() >= modulo.getCorso().getMaxIscritti()) {
										lezioneDao.save(new Lezione(modulo, ldti, ldtf, altraAula));
										monteOre += ChronoUnit.HOURS.between(sol.getOraInizio(), sol.getOraFine());
										break; //per non controllare le altre aule
									}
								}
							}	
						}
						if (day.getValue() == lastDayOfWeek) {
							firstDay = DayOfWeek.of(1);
						} else {
							firstDay = DayOfWeek.of(day.getValue() + 1);
						}
					} else {
						if (firstDay.getValue() > lastDayOfWeek) {
							firstDay = DayOfWeek.of(1);
						}else {
							
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
	@Override
	public Course add(Course t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
