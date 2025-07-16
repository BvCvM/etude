package com.app.etude.etude.dto;

import lombok.Builder;
import lombok.Data;
import com.app.etude.etude.models.Absence;
import java.util.Date;
import java.util.List;

@Builder
@Data // regroupe : les getters , les setters ,toString() ...
public class AbsenceDto {
    private Long id;
    private Date date;
    private String matiere;
    private Long professeurId;
    private List<Long> slotEmploiTempsId;
    private Long eleveID;


    public static Absence toEntity(AbsenceDto request)
    {
        return Absence.builder()
                .id(request.getId())
                .date(request.getDate())
                .matiere(request.getMatiere())
                .build();

    }
    public static AbsenceDto fromEntity(Absence request)
    {
        return AbsenceDto.builder()
                .id(request.getId())
                .date(request.getDate())
                .matiere(request.getMatiere())
                .build();

    }
}
