package com.app.etude.etude.models;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="matiere")
@AllArgsConstructor //contructeur parametrer
@NoArgsConstructor //constructeur par default
@Setter 
@Getter
@Builder
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Génère les ID automatiquement
	private long id ;
	@Column
	private String coeff;
	private int duree;
	private String nom;
	@OneToMany(fetch=FetchType.LAZY)
	private List<Devoir> devoirs;
	@OneToMany(fetch=FetchType.LAZY)
	private List<Cours> cours;
	@OneToMany(fetch=FetchType.LAZY)
	private List<Emploie> emploie;
}

