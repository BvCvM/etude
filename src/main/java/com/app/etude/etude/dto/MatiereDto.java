package com.app.etude.etude.dto;

import com.app.etude.etude.models.Classes;
import com.app.etude.etude.models.Matiere;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatiereDto {

	private long id ;
	private String coeff;
	private int duree;
	private String nom;
	
	 public static Matiere toEntity(MatiereDto dto) {
	        return Matiere.builder()
	                .id(dto.getId())
	                .coeff(dto.getCoeff())
	                .duree(dto.getDuree())
	                .nom(dto.getNom())
	                .build();
	    }

	    public static MatiereDto fromEntity(Matiere entity) {
	        return MatiereDto.builder()
	                .id(entity.getId())
	                .coeff(entity.getCoeff())
	                .duree(entity.getDuree())
	                .nom(entity.getNom())
	                .build();
	    }
}
