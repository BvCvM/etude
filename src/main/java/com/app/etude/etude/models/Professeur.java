package com.app.etude.etude.models;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.app.etude.etude.security.models.User;
@Entity
@SuperBuilder // le classe fils herite de la classe parent des champs (builder fluid)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professeur extends User {
	@Column
	private String cin;
	@Column
	private String diplome;
	@Column
	private Date dateDebutTravail;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Matiere> matieres;
	@OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY)
	private List<Absence> absences;
	
}

