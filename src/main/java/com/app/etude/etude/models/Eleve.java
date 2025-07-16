package com.app.etude.etude.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.app.etude.etude.models.NiveauScolaire;
import java.time.LocalDate;
import java.util.List;

import com.app.etude.etude.security.models.User;

@Entity
@SuperBuilder
@AllArgsConstructor //contructeur parametrer
@NoArgsConstructor //constructeur par default
@Setter 
@Getter
public class Eleve extends User{
	@Column
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private  NiveauScolaire niveauScolaire;
	@OneToMany(fetch=FetchType.LAZY)
	private List<Absence> absences;
	@ManyToOne(fetch=FetchType.LAZY)
	private Classes classe ;
	@ManyToOne(fetch=FetchType.LAZY)
	Parent parent;
}

