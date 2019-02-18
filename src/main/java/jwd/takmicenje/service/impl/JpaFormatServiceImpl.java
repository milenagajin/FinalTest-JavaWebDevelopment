package jwd.takmicenje.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import jwd.takmicenje.model.Format;
import jwd.takmicenje.repository.FormatRepository;
import jwd.takmicenje.service.FormatService;
@Transactional
@Service
public class JpaFormatServiceImpl implements FormatService{
	
	
	@Autowired
	private FormatRepository formatRepository;
	
	
	@Override
	public Page<Format> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Format findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Format f) {
		formatRepository.save(f);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
