package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.dto.MatiereDto;
import com.app.etude.etude.models.Matiere;

public interface MatiereServices {
	List<MatiereDto> findAllMatieres();
	MatiereDto findMatierebyid(Long id);
	MatiereDto CreateMatiere(MatiereDto a);
	void DeleteMatiere(Long id);
	MatiereDto UpdateMatiere(MatiereDto a);
	List<MatiereDto> ChercherMatiere(String a);
	
	
	
}
