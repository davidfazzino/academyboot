package it.bit.academy.academyBoot.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import it.bit.academy.academyBoot.dto.DatiCreazioneIscrizione;
import it.bit.academy.academyBoot.dto.IscrizioneDto;
import it.bit.academy.academyBoot.dto.StudentDto;
import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
import it.bit.academy.academyBoot.exceptions.ImpossibleEnrollException;
import it.bit.academy.academyBoot.exceptions.IscrizioneNotFoundException;
import it.bit.academy.academyBoot.exceptions.StudentNotFoundException;
import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.model.Iscrizione;
import it.bit.academy.academyBoot.model.Student;
import it.bit.academy.academyBoot.repository.CourseDao;
import it.bit.academy.academyBoot.repository.IscrizioneDao;
import it.bit.academy.academyBoot.repository.StudentDao;

@Service
public class IscrizioneServiceImpl implements IscrizioneService{
	private StudentDao studentDao;
	private IscrizioneDao iscrizioneDao;
	private CourseDao courseDao;
	
	@Autowired
	public IscrizioneServiceImpl(IscrizioneDao iscrizioneDao, StudentDao studentDao, CourseDao courseDao) {
		this.studentDao=studentDao;
		this.iscrizioneDao = iscrizioneDao;
		this.courseDao=courseDao;
	}

	@Override
	@Transactional
	public List<Iscrizione> findAll() {
		return iscrizioneDao.findAll();
	}

	@Override
	@Transactional
	public Iscrizione findById(int id) throws IscrizioneNotFoundException {
		return iscrizioneDao.findById(id).orElseThrow(()->new IscrizioneNotFoundException("iscrizione non trovata"));
	}

	@Override
	@Transactional
	public void add(DatiCreazioneIscrizione t) throws StudentNotFoundException,CourseNotFoundException, ImpossibleEnrollException {
		System.out.println(t.getIdStudente() +"------------"+ t.getIdCorso());
		Student s = studentDao.findById(t.getIdStudente()).orElseThrow(()->new StudentNotFoundException("lo studente non è stato trovato"));
		Course c = courseDao.findById(t.getIdCorso()).orElseThrow(()->new CourseNotFoundException("il corso non è stato trovato"));
		int iscritti = (int)studentDao.findByCourse(c.getId()).stream().count();
		if(iscritti < c.getMaxIscritti()) {
			Iscrizione i= new Iscrizione(s,c,LocalDate.now());
			iscrizioneDao.save(i);
		}else {
			throw new ImpossibleEnrollException("Limite iscritti raggiunto!");
		}
	}
	
	
	
	@Override
	@Transactional
	public void remove(int id) throws IscrizioneNotFoundException {
	
		Optional<Iscrizione> st = iscrizioneDao.findById(id);
		Iscrizione s = st.orElseThrow(()->new IscrizioneNotFoundException("Iscrizione con id " + id + "non trovato!"));
		iscrizioneDao.deleteById(s.getId());
		//iscrizioneDao.delete(s);
		System.out.println("dopo la chiamate delete----------"+s.getId());
	}
	
	
	@Override
	@Transactional
	public void update(Iscrizione t) {
			
	}

	@Override
	@Transactional
	public Iscrizione add(Iscrizione t) {
		
		return iscrizioneDao.save(t);
	}

	@Override
	public void removeByCorsoAndStudente(int idStudente, int idCorso) throws IscrizioneNotFoundException{
		
		Iscrizione s= iscrizioneDao.findByCorsoAndStudente(idStudente, idCorso).orElseThrow(()->new IscrizioneNotFoundException("l'iscrizione non è stata trovata"));
		iscrizioneDao.delete(s);
		
		
	}

	@Override
	@Transactional
	public void patchValutazione(int id, Integer valutazione, Boolean ritirato) throws IscrizioneNotFoundException {
		Iscrizione i=iscrizioneDao.findById(id).orElseThrow(()->new IscrizioneNotFoundException("l'iscrizione non è stata trovata"));
		
		if(valutazione!=null) {
			i.setValutazione(valutazione);
		}
		if(ritirato!=null) {
			i.setRitirato(ritirato);
		}
		
		
		
		//iscrizioneDao.save(i);
	}

	

	

	
	
	
}
