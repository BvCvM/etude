package com.app.etude.etude.models;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="devoir")
public class Devoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String titre;
    private String description;
    private Date dateCreation;
    private Date dateLimite;
    @ManyToMany(mappedBy = "devoirs")
    private List<Classes> classes;
    
    public Devoir(Integer id, String titre, String description, Date dateCreation, Date dateLimite) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateLimite = dateLimite;
	}
	public Devoir() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateLimite() {
		return dateLimite;
	}
	public void setDateLimite(Date dateLimite) {
		this.dateLimite = dateLimite;
	}
    
    
    

}