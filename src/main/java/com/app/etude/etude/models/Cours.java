
package com.app.etude.etude.models;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long salle;
    private String titre;
    private Date dateCours;
    private String urlcours;
    private String filecours;
    private Time heureDebut;
    private Time heureFin;
    @ManyToMany(mappedBy = "cours")
    private List<Classes> classes;

}
