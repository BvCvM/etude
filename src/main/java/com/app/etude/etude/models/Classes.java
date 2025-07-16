package com.app.etude.etude.models;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="classes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String titre;
    private String anneescolaire;
    
    @OneToMany(fetch=FetchType.LAZY)
    private List<Eleve> eleves; 
    @ManyToMany(fetch=FetchType.LAZY)
    private List<Cours> cours;
    @ManyToMany(fetch=FetchType.LAZY)
    private List<Devoir> devoirs;
    
}


