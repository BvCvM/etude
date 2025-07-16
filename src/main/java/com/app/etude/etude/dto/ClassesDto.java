package com.app.etude.etude.dto;

import java.util.Date;
import java.util.List;

import com.app.etude.etude.models.Classes;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesDto {
	private long id;
    private String titre;
    private String anneescolaire;
    
    public static Classes toEntity(ClassesDto dto) {
        return Classes.builder()
                .id(dto.getId())
                .titre(dto.getTitre())
                .anneescolaire(dto.getAnneescolaire())
                .build();
    }

    public static ClassesDto fromEntity(Classes entity) {
        return ClassesDto.builder()
                .id(entity.getId())
                .titre(entity.getTitre())
                .anneescolaire(entity.getAnneescolaire())
                .build();
    }
    
    

}
