package com.app.etude.etude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.etude.etude.models.Cours;

public interface Coursrepository extends JpaRepository<Cours,Long> {
	
	 List<Cours> findByClasses_IdAndMatiere_IdMatiere(Long classId, Long matiereId);
}
