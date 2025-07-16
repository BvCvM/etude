package com.app.etude.etude.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.etude.etude.dto.ClassesDto;
import com.app.etude.etude.dto.MatiereDto;
import com.app.etude.etude.models.Classes;
import com.app.etude.etude.models.Matiere;
import com.app.etude.etude.repository.Matiererepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatiereServicesImpl implements MatiereServices {
	
	private final Matiererepository matiereRepository;
	@Override
	public List<MatiereDto> findAllMatieres() {
		List<Matiere> classesList = matiereRepository.findAll();
        return classesList.stream()
                          .map(MatiereDto::fromEntity)
                          .collect(Collectors.toList());
	}

	@Override
	public MatiereDto findMatierebyid(Long id) {
		Matiere m = matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec id: " + id));
return MatiereDto.fromEntity(m);
	}

	@Override
	public MatiereDto CreateMatiere(MatiereDto a) {
		Matiere matieres = MatiereDto.toEntity(a);
		Matiere saved = matiereRepository.save(matieres);
        return MatiereDto.fromEntity(saved);
	}

	@Override
	public void DeleteMatiere(Long id) {
		  if (!matiereRepository.existsById(id)) {
	            throw new RuntimeException("Classe introuvable avec id: " + id);
	        }
		  matiereRepository.deleteById(id);
		
	}

	@Override
	public MatiereDto UpdateMatiere(MatiereDto a) {
		Matiere matiere = matiereRepository.findById(a.getId())
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec id: " + a.getId()));
		 
		matiere.setCoeff(a.getCoeff());;
		matiere.setDuree(a.getDuree());
		Matiere classsaved = matiereRepository.save(matiere);
		return MatiereDto.fromEntity(classsaved);
	}

	@Override
	public List<MatiereDto> ChercherMatiere(String nom) {
		List<Matiere> classesList = matiereRepository.findByNomContainingIgnoreCase(nom);
        return classesList.stream()
                          .map(MatiereDto::fromEntity)
                          .collect(Collectors.toList());
		
	}
	
	
	

}
