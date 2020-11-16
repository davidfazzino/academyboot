package it.bit.academy.academyBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bit.academy.academyBoot.model.Lezione;
import it.bit.academy.academyBoot.repository.LezioneDao;

@Service
public class LezioneServiceImpl implements LezioneService {

	private LezioneDao lezioneDao;
	
	@Autowired
	public LezioneServiceImpl(LezioneDao lezioneDao) {
		this.lezioneDao = lezioneDao;
	}
	
	@Override
	public List<Lezione> findAll() {
		return lezioneDao.findAll();
	}

	@Override
	public Lezione findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lezione add(Lezione t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Lezione t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Lezione> findByAula(String nomeAula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lezione> findByModulo(String modulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
