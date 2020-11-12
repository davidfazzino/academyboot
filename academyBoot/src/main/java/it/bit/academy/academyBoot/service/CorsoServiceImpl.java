package it.bit.academy.academyBoot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
import it.bit.academy.academyBoot.exceptions.IscrizioneNotFoundException;
import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.model.Lezione;
import it.bit.academy.academyBoot.model.Modulo;
import it.bit.academy.academyBoot.model.PreferenzeCalendario;
import it.bit.academy.academyBoot.repository.CourseDao;
import it.bit.academy.academyBoot.repository.LezioneDao;
@Service
public class CorsoServiceImpl implements CorsoService {
	private CourseDao courseDao;
	private LezioneDao lezioneDao;
	
	
	@Autowired
	public CorsoServiceImpl(CourseDao courseDao,LezioneDao lezioneDao) {
		this.courseDao=courseDao;
		this.lezioneDao=lezioneDao;
		
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
		List<Modulo> listaModuli=c.getListaModulo();
		for (Modulo modulo : listaModuli) {
			
			
//			List<Lezione> listaLezione=lezioneDao.findByAula(modulo.getAulaPreferita());
//			for (Lezione lez : listaLezione) {
//				List<PreferenzeCalendario> listPrefe=modulo.getListaPreferenzaCalendario();
//				for(PreferenzeCalendario pr:listPrefe) {
//					lezioneDao.findByAulaAndGiorno(, modulo.getAulaPreferita())
//					
//				}
//			}
			
		}
		
		
		
		return c;
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
