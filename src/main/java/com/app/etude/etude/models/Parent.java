package com.app.etude.etude.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.app.etude.etude.security.models.User;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("parent") //chaque parent enregistrer sa valeur utiliser dans une colonne descriminante
public class Parent extends User {
	@Column
	private String description;
	@OneToMany(mappedBy ="parent", fetch=FetchType.LAZY)
	private List<Eleve> eleves;
	

}
