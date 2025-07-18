
package com.app.etude.etude.models;
import java.sql.Date;
import java.sql.Time;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cours")
@AllArgsConstructor //contructeur parametrer
@NoArgsConstructor //constructeur par default
@Setter 
@Getter
@Builder
public class Cours {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	private String titre;
	private String urlcours;
	private String filecours;
	@ManyToOne(fetch = FetchType.LAZY)
	private Professeur professeur; 
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Classes> classes;
	@ManyToOne(fetch = FetchType.LAZY)
	private Matiere matiere;


}
