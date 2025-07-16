package com.app.etude.etude.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.etude.etude.dto.Professeurdto;
import com.app.etude.etude.models.Professeur;
import com.app.etude.etude.repository.ProfesseurRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProfesseurServices {
	private final ProfesseurRepository professeurRepository;
	public List<Professeurdto> findAll(){
		 return professeurRepository.findAll() // récupère tous les professeurs depuis la base de données
		.stream() //transform list des proffesseur en flux
		.map(Professeurdto::fromEntity) //transform chaque element en flux
		.collect(Collectors.toList());		
	}
	public Professeurdto findProfById(Long id) {
		Optional<Professeur> optionalprof =professeurRepository.findById(id);
		optionalprof.orElseThrow(() -> new RuntimeException("prf not found with id : " +id ));
		return Professeurdto.fromEntity(optionalprof.get());
	}
	public void deleteProfById(Long idprof) {
		professeurRepository.deleteById(idprof);
	}
	
}
