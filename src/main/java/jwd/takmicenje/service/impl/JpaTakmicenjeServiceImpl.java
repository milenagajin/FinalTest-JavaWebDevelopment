package jwd.takmicenje.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.takmicenje.model.Takmicenje;
import jwd.takmicenje.repository.TakmicenjeRepository;
import jwd.takmicenje.service.TakmicenjeService;

@Transactional
@Service
public class JpaTakmicenjeServiceImpl implements TakmicenjeService {
	@Autowired
	private TakmicenjeRepository takmicenjeRepository;
	
	

	@Override
	public List<Takmicenje> findAll() {
		return takmicenjeRepository.findAll();
	}

	@Override
	public Takmicenje findOne(Long id) {
		return takmicenjeRepository.findOne(id);
	}

	@Override
	public void save(Takmicenje t) {
		takmicenjeRepository.save(t);
	}

	@Override
	public void remove(Long id) {
		
	}

	
	
	
}
