package jwd.takmicenje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.takmicenje.model.Format;

@Repository
public interface FormatRepository 
	extends JpaRepository<Format, Long> {

//	Page<Festival> findByMestoId(Long mestoId, Pageable pageRequest);
//
//	@Query("SELECT f FROM Festival f WHERE "
//			+ "(:naziv IS NULL or f.naziv like :naziv ) AND "
//			+ "(:maxCena IS NULL OR f.cenaKarte <= :maxCena) AND "
//			+ "(:idMesta IS NULL or f.mesto.id = :idMesta )"
//			)
//	Page<Festival> pretraga(
//			@Param("naziv") String naziv, 
//			@Param("maxCena") Double maxCena, 
//			@Param("idMesta") Long idMesta,
//			Pageable pageRequest);

}
