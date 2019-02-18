package jwd.takmicenje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.takmicenje.model.Takmicenje;

@Repository
public interface TakmicenjeRepository 
	extends JpaRepository<Takmicenje, Long> {

}
