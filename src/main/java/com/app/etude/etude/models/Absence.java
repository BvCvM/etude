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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor //contructeur parametrer
@NoArgsConstructor //constructeur par default
@Table(name="Absence")
@Setter 
@Getter
@SuperBuilder
public class Absence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Génère les ID automatiquement
	private long id ;
	@Column
	private Date date;
	private String matiere;
	
	@ManyToOne(fetch = FetchType.LAZY) //l'objet ne charge pas rapidement 
	private Eleve eleve;
	@ManyToOne(fetch = FetchType.LAZY) //l'objet ne charge pas rapidement 
	private Professeur professeur;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<SlotEmploiesTemps> seances;
	
}

