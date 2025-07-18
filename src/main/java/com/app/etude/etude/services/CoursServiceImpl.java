package com.app.etude.etude.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.etude.etude.dto.CoursDto;
import com.app.etude.etude.dto.ListCour;
import com.app.etude.etude.models.Classes;
import com.app.etude.etude.models.Cours;
import com.app.etude.etude.models.Matiere;
import com.app.etude.etude.models.Professeur;
import com.app.etude.etude.repository.Classesrepository;
import com.app.etude.etude.repository.Coursrepository;
import com.app.etude.etude.repository.Matiererepository;
import com.app.etude.etude.repository.ProfesseurRepository;

import ConfigFile.ImageStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor


public class CoursServiceImpl implements CoursService {
	  private final Coursrepository coursRepository;
	    private final ProfesseurRepository professeurRepository;
	    private final Classesrepository classesRepository;
	    private final ImageStorage imageStorage;
	    private final Matiererepository matiereRepository;


	    @Override
	    public List<CoursDto> findAllCours() {
	        return coursRepository.findAll().stream()
	                .map(CoursDto::fromEntity)
	                .collect(Collectors.toList());
	    }
	    @Override
	    public CoursDto findCourById(Long id) {
	        Optional<Cours> optionalCours = coursRepository.findById(id);
	        optionalCours.orElseThrow(() -> new RuntimeException("Cours not found with id: " + id));
	        return CoursDto.fromEntity(optionalCours.get());
	    }


	   @Override
	    public CoursDto createCours(CoursDto coursDto ,Authentication connectedUser) {
//	        Professeur professeur = professeurRepository.findById(coursDto.getProfesseurId(), Authentication connectedUser,)
//	                .orElseThrow(() -> new EntityNotFoundException("No Professeur found with ID:: " + coursDto.getProfesseurId()));
	        Professeur professeur = ((Professeur) connectedUser.getPrincipal());
	        Matiere matiere = matiereRepository.findById(coursDto.getMatiereId())
	                .orElseThrow(() -> new EntityNotFoundException("No Matiere found with ID:: " + coursDto.getMatiereId()));


	        List<Classes> classes= new ArrayList<>();
	        if (coursDto.getClassesIds().isEmpty()) {
	            throw new IllegalArgumentException("you need atleast on classes");
	        } else {
	            for (Long classeId : coursDto.getClassesIds()) {
	                Optional<Classes> classes1 = classesRepository.findById(classeId);
	                classes1.ifPresent(classes::add);
	            }
	        }
	        Cours cours = CoursDto.toEntity(coursDto);
	        cours.setClasses(classes);
	        cours.setProfesseur(professeur);
	        cours.setMatiere(matiere);
	        return CoursDto.fromEntity(coursRepository.save(cours));
	    }  


	    @Override
	    public List<ListCour> findAllCoursByclasseAndmatiere(Long classId, Long matiereId) {
	        return coursRepository.findByClasses_IdAndMatiere_IdMatiere(classId,matiereId).stream()
	                .map(ListCour::fromEntity)
	                .collect(Collectors.toList());
	    }


	    @Override
	    public void deleteCourById(Long courId) {
	        coursRepository.deleteById(courId);
	    }
	    public ResponseEntity<Cours> findbyId(Long id) {
	        if (id == null) {
	          //  log.error("student ID is null");
	            return null;
	        }
	        return ResponseEntity.ok(coursRepository.findById(id).get());
	                
	    }
	@Override
	public CoursDto uploadcoursfile(Long IdCours, MultipartFile image) {
		 ResponseEntity<Cours> coursResponse = this.findbyId(IdCours);
	        String imageName=imageStorage.store(image);
	        String fileImageDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("api/cours/downloadcoursFile/").path(imageName).toUriString();
	        Cours cours = coursResponse.getBody();
	       
	        if (cours!=null)
	        	cours.setFilecours(fileImageDownloadUrl); 
	        Cours courssaved = coursRepository.save(cours);
	        return  CoursDto.fromEntity(courssaved);
	        		 
	}
	




}
