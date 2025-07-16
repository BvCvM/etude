package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.dto.ClassesDto;
import com.app.etude.etude.models.Classes;
public interface ClassesServices {
	
	List<ClassesDto> findAllClasses();
	ClassesDto findClassebyid(Long id);
	ClassesDto CreateClasse(ClassesDto a);
	ClassesDto UpdateClasse(ClassesDto a);
	void DeleteById(Long id);
	
}
