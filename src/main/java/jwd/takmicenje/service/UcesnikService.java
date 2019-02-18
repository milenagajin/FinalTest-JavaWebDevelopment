package jwd.takmicenje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.takmicenje.model.Ucesnik;

public interface UcesnikService {
	
	Page<Ucesnik> findAll(int pageNum);
	Ucesnik findOne(Long id);
	Ucesnik save(Ucesnik igrac);
	void remove(Long id);
	Page<Ucesnik> findByTakmicenjeId(int pageNum, Long takmicenjeId);
	Page<Ucesnik> pretraga(@Param("naziv")String naziv, @Param("takmicenjeId")Long takmicenjeId, int pageNum);
	
	
	
	
	
}
