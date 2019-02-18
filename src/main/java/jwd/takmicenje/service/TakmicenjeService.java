package jwd.takmicenje.service;

import java.util.List;

import jwd.takmicenje.model.Takmicenje;


public interface TakmicenjeService {
	List<Takmicenje> findAll();
	Takmicenje findOne(Long id);
	void save(Takmicenje sajam);
	void remove(Long id);

}
