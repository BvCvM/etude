package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Devoir;
import com.app.etude.etude.services.DevoirServices;

@RestController
@RequestMapping("/api/Devoir")
public class DevoirControleur {
	
	private DevoirServices Devoirservices;
	
	@GetMapping("/allDevoir")
    public List<Devoir> findAllDevoirs()
	{
		return Devoirservices.findAllDevoirs();
	}
	@GetMapping("/{id}")
    public Devoir findDevoirbyid(@PathVariable Long id)
	{
		return Devoirservices.findDevoirbyid(id);
	}
	
}
