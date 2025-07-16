package com.app.etude.etude.dto;

import java.util.List;

import com.app.etude.etude.models.Cours;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CoursDto {
    private Long id;
    private String titre;
    private String urlcours;
    private String filecours;
    private List<Long> classesIds;
    private Long professeurId;
    private Long matiereId;

    public static Cours toEntity(CoursDto request)
    {
        return Cours.builder()
            .id(request.getId())
            .titre(request.getTitre())
            .urlcours(request.getUrlcours())
            .filecours(request.getFilecours())
            .build();
    }
    
    public static CoursDto fromEntity(CoursDto request)
    {
        return CoursDto.builder()
            .id(request.getId())
            .titre(request.getTitre())
            .urlcours(request.getUrlcours())
            .filecours(request.getFilecours())
            .build();
    }
}