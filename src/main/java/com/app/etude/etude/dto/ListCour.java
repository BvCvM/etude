package com.app.etude.etude.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;


import java.util.List;

import com.app.etude.etude.models.Cours;
import com.app.etude.etude.models.Professeur;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCour {


    private Long idCours;
    private String titre;
    private String urlcours;
    private String filecours;
    @ManyToOne(fetch = FetchType.LAZY)
    private Professeur professeur;
    private List<Long> classesId;
    private  MatiereDto matiereDto;




    public static Cours toEntity(ListCour request)
    {
        return Cours.builder()
                .id(request.getIdCours())
                .titre(request.getTitre())
                .urlcours(request.getUrlcours())
                .filecours(request.getFilecours())
                .build();


    }
    public static ListCour fromEntity(Cours request)
    {
        return ListCour.builder()
                .idCours(request.getId())
                .titre(request.getTitre())
                .urlcours(request.getUrlcours())
                .filecours(request.getFilecours())
                .matiereDto(MatiereDto.fromEntity(request.getMatiere()))
                .build();


    }


}
