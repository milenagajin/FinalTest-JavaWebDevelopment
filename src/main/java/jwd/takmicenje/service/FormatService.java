package jwd.takmicenje.service;

import org.springframework.data.domain.Page;

import jwd.takmicenje.model.Format;

public interface FormatService {
	Page<Format> findAll(int pageNum);
	Format findOne(Long id);
	void save(Format f);
	void remove(Long id);
//	Format buy(Long id);
//	Page<Festival> findByMestoId(int pageNum, Long mestoId);
//	Page<Festival> pretraga(
//			@Param("naziv") String naziv, 
//			@Param("maxCena") Double maxCena,
//			@Param("idMesta") Long idMesta, 
//			int page);
}
