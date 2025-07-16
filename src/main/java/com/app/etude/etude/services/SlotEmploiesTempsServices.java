package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.SlotEmploiesTemps;

public interface SlotEmploiesTempsServices {
	List<SlotEmploiesTemps> findAllSlotEmploiesTempss();
	SlotEmploiesTemps findSlotEmploiesTempsbyid(Long id);
	
	SlotEmploiesTemps CreateSlotEmploiesTemps(SlotEmploiesTemps a);
	
}
