package com.app.etude.etude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.etude.etude.models.Cours;

public interface Coursrepository extends JpaRepository<Cours,Long> {

}
