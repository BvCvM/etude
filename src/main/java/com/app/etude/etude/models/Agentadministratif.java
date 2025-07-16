package com.app.etude.etude.models;

import java.util.Date;
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
@DiscriminatorValue("Agentadministratif") //chaque Agentadministratif enregistrer sa valeur utiliser dans une colonne descriminante
public class Agentadministratif extends User {
	@Column
	private Date datederecrutement;
	
}
