package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.services.EleveServices;

@RestController
@RequestMapping("/api/Eleve")
public class EleveControleur {
	
	private EleveServices Eleveservices;
	
	@GetMapping("/allEleve")
    public List<Eleve> findAllEleves()
	{
		return Eleveservices.findAllEleves();
	}
	@GetMapping("/{id}")
    public Eleve findElevebyid(@PathVariable Long id)
	{
		return Eleveservices.findElevebyid(id);
	}
	
}
