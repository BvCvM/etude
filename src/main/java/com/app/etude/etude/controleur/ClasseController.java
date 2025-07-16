package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.dto.ClassesDto;
import com.app.etude.etude.services.ClassesServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
public class ClasseController {
	private final ClassesServices classesServices;

	@GetMapping("/lister")
	public List<ClassesDto> findAllClasses() {
		return classesServices.findAllClasses();
	}
	@GetMapping("/getById/{id}")
	public ClassesDto findClassebyid(@PathVariable	Long id) {
		return classesServices.findClassebyid(id);
	}
	@PostMapping("/save")
	public ClassesDto CreateClasse(@RequestBody ClassesDto a) {
		return classesServices.CreateClasse(a);
	}
	@DeleteMapping("/delete/{id}")
	public void DeleteById(@PathVariable Long id) {
		classesServices.DeleteById(id);
	}
	@PostMapping("/update")
	public ClassesDto UpdateClasse(@RequestBody ClassesDto a) {
		return classesServices.UpdateClasse(a);
	}
	
	
	
	
	
	
	
}
