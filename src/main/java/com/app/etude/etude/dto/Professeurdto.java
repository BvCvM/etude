package com.app.etude.etude.dto;

import java.util.Date;

import com.app.etude.etude.security.auth.RegisterRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.app.etude.etude.models.Professeur;

@Getter()
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // permet d utiliser le pattern build

public class Professeurdto extends RegisterRequest  { // heritage 
	private String cin;
	private String diplome;
	private Date dateDebutTravail;
	 public static Professeur toEntity(Professeurdto request) //convertir le dto en entite JPA
	    {
	        return Professeur.builder() // le builder inclut automatiquement tout les champs heriter de registre request 
	                .id(request.getId())
	                .firstName(request.getFirstName())
	                .lastName(request.getLastName())
	                .email(request.getEmail())
	                .password(request.getPassword())
	                .adress(request.getAdress())
	                .phone(request.getPhone())
	                .cin(request.getCin())
	                .diplome(request.getDiplome())
	                .dateDebutTravail(request.getDateDebutTravail())
	                .build();
	    }
	 public static Professeurdto fromEntity(Professeur request)
	    {
	        return Professeurdto.builder()
	                .id(request.getId())
	                .firstName(request.getFirstName())
	                .lastName(request.getLastName())
	                .email(request.getEmail())
	                .adress(request.getAdress())
	                .phone(request.getPhone())
	                .cin(request.getCin())
	                .diplome(request.getDiplome())
	                .dateDebutTravail(request.getDateDebutTravail())
	                .build();
	    }
	 

}
