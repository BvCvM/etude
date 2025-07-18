package com.app.etude.etude.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.app.etude.etude.dto.CoursDto;
import com.app.etude.etude.dto.ListCour;
import com.app.etude.etude.models.Cours;

public interface CoursService {
	 List<CoursDto> findAllCours();
	    CoursDto findCourById(Long id);
	    void deleteCourById(Long courId);
	    CoursDto uploadcoursfile(Long Idarticle, MultipartFile image);
	    CoursDto createCours(CoursDto coursDto, Authentication connectedUser);
	    List<ListCour> findAllCoursByclasseAndmatiere(Long classId, Long matiereId);

}
