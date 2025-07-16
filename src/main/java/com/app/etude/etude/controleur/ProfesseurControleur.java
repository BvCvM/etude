package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.dto.Professeurdto;
import com.app.etude.etude.models.Professeur;
import com.app.etude.etude.services.ProfesseurServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/Professeur")
@RequiredArgsConstructor
public class ProfesseurControleur {
	
	private final ProfesseurServices Professeurservices;
	
	@GetMapping("/allProfesseur")
    public List<Professeurdto> findAllProfesseurs()
	{
		return Professeurservices.findAll();
	}
	@GetMapping("/{id}")
    public Professeurdto findProfesseurbyid(@PathVariable Long id)
	{
		return Professeurservices.findProfById(id);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteClasses(@PathVariable("id") Long id){
		Professeurservices.deleteProfById(id);
		return ResponseEntity.noContent().build();
	}
	
}
