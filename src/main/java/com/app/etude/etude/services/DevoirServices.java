package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Devoir;

public interface DevoirServices {
	List<Devoir> findAllDevoirs();
	Devoir findDevoirbyid(Long id);
	
	Devoir CreateDevoir(Devoir a);
	
}
