package com.app.etude.etude.models;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emploie")
@Getter
@Setter
public class Emploie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Génère les ID automatiquement
	private long id ;
	@Column
	private String salle;
	private String anneescolaire;
	
	@ManyToOne(fetch =FetchType.LAZY)
	private Classes classe;
	@ManyToOne(fetch =FetchType.LAZY)
	private Professeur professeur;
	@ManyToOne(fetch =FetchType.LAZY)
	private Matiere matiere;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<SlotEmploiesTemps> seances;
}

