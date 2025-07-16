package com.app.etude.etude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.etude.etude.models.Matiere;



public interface Matiererepository extends JpaRepository<Matiere,Long> {
	
	List<Matiere> findByNomContainingIgnoreCase(String nom);

}
