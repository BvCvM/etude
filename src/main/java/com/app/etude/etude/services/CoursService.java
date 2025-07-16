package com.app.etude.etude.services;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.app.etude.etude.dto.CoursDto;
import com.app.etude.etude.models.Cours;

public interface CoursService {
    List<CoursDto> findAllCours();
    CoursDto findCourById(Long id);

    void deleteCourById(Long courId);
    CoursDto uploadcoursfile(Long Idarticle, MultipartFile image);
    CoursDto createCours(CoursDto coursDto, Authentication connectedUser);
    List<List<Cours>> findAllCoursByclasseAndmatiere(Long classId, Long matiereId);
}
