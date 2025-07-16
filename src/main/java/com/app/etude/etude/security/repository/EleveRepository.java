package com.app.etude.etude.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.models.NiveauScolaire;

import java.util.List;
import java.util.Optional;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
    @Query("select u from Eleve u where u.niveauScolaire = ?1 ")
    List<Eleve> listAllEleveByNiv(NiveauScolaire niveauScolaire);
    @Query("select u from Eleve u where u.niveauScolaire = ?1")
    List<Eleve> listAllEleveByNivAndPaye(NiveauScolaire niveauScolaire);
    Optional<Eleve> findByEmail(String email);
    @Query("select u from Eleve u where u.classe.id = ?1")
    List<Eleve> listAllEleveByClasse(Long id);

    @Query("select u from Eleve u where u.parent.id = ?1 ")
    List<Eleve> listEleveByParent(Long id);

}
