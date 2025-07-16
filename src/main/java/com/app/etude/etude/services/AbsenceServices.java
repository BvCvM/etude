package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Absence;
public interface AbsenceServices {
	
	List<Absence> findAllAbsences();
	Absence findAbsencebyid(Long id);
	Absence CreateAbsence(Absence a);
	
}
