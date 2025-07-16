package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Eleve;

public interface EleveServices {
	List<Eleve> findAllEleves();
	Eleve findElevebyid(Long id);
	
	Eleve CreateEleve(Eleve e);
	
}
