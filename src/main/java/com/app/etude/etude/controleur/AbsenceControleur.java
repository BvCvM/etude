package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Absence;
import com.app.etude.etude.services.AbsenceServices;

@RestController
@RequestMapping("/api/Absence")
public class AbsenceControleur {
	
	private AbsenceServices Absenceservices;
	
	@GetMapping("/allAbsence")
    public List<Absence> findAllAbsences()
	{
		return Absenceservices.findAllAbsences();
	}
	@GetMapping("/{id}")
    public Absence findAbsencebyid(@PathVariable Long id)
	{
		return Absenceservices.findAbsencebyid(id);
	}
	
}
