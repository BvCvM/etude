package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Emploie;
import com.app.etude.etude.services.EmploieServices;

@RestController
@RequestMapping("/api/Emploie")
public class EmploieControleur {
	
	private EmploieServices Emploieservices;
	
	@GetMapping("/allEmploie")
    public List<Emploie> findAllEmploies()
	{
		return Emploieservices.findAllEmploies();
	}
	@GetMapping("/{id}")
    public Emploie findEmploiebyid(@PathVariable Long id)
	{
		return Emploieservices.findEmploiebyid(id);
	}
	
}
