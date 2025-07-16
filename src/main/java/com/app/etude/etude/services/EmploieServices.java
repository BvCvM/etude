package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Emploie;

public interface EmploieServices {
	List<Emploie> findAllEmploies();
	Emploie findEmploiebyid(Long id);
	
	Emploie CreateEmploie(Emploie e);
}
