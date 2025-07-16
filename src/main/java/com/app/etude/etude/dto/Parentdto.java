package com.app.etude.etude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.models.Parent;
import com.app.etude.etude.security.auth.RegisterRequest;

@Getter()
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Parentdto extends RegisterRequest{
	private String description;
	 public static Parent toEntity(Parentdto request)
	    {
	        return Parent.builder()
	                .id(request.getId())
	                .firstName(request.getFirstName())
	                .lastName(request.getLastName())
	                .email(request.getEmail())
	                .password(request.getPassword())
	                .adress(request.getAdress())
	                .phone(request.getPhone())
	                .description(request.getDescription())
	                .build();
	    }
	 public static Parentdto fromEntity(Parent request)
	    {
	        return Parentdto.builder()
	                .id(request.getId())
	                .firstName(request.getFirstName())
	                .lastName(request.getLastName())
	                .email(request.getEmail())
	                .password(request.getPassword())
	                .adress(request.getAdress())
	                .phone(request.getPhone())
	                .description(request.getDescription())
	                .build();
	    }
	 
	 
}
