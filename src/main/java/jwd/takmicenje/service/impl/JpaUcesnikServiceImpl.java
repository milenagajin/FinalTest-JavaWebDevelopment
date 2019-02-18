package jwd.takmicenje.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.takmicenje.model.Ucesnik;
import jwd.takmicenje.repository.UcesnikRepository;
import jwd.takmicenje.service.UcesnikService;

@Transactional
@Service
public class JpaUcesnikServiceImpl implements UcesnikService {

	
	@Autowired
	private UcesnikRepository ucesnikRepository;
	
		
	@Override
	public Page<Ucesnik> findAll(int pageNum) {
		return ucesnikRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Ucesnik findOne(Long id) {
		return ucesnikRepository.findOne(id);
	}

	@Override
	public Ucesnik save(Ucesnik u) {
		int brojDozvoljenihIgraca = u.getTakmicenje().getFormat().getBrojUcesnika();
		int trenutniBrIgraca = u.getTakmicenje().getFormat().getTakmicenja().size();
		if(brojDozvoljenihIgraca - trenutniBrIgraca >= 1)
			return ucesnikRepository.save(u);
		return null;
	}

	@Override
	public void remove(Long id) {
		ucesnikRepository.delete(id);
	}

	@Override
	public Page<Ucesnik> findByTakmicenjeId(int pageNum, Long takmicenjeId) {
		return ucesnikRepository.findByTakmicenjeId(takmicenjeId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Ucesnik> pretraga(String naziv, Long takmicenjeId, int pageNum) {
		
		if(naziv != null) 
			naziv = "%" + naziv + "%";
		
		return ucesnikRepository.pretraga(naziv, takmicenjeId, new PageRequest(pageNum, 5));
	}

	
	
	

}
