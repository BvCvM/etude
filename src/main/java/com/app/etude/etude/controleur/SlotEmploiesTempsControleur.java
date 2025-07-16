package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.SlotEmploiesTemps;
import com.app.etude.etude.services.SlotEmploiesTempsServices;

@RestController
@RequestMapping("/api/SlotEmploiesTemps")
public class SlotEmploiesTempsControleur {
	
	private SlotEmploiesTempsServices SlotEmploiesTempsservices;
	
	@GetMapping("/allSlotEmploiesTemps")
    public List<SlotEmploiesTemps> findAllSlotEmploiesTempss()
	{
		return SlotEmploiesTempsservices.findAllSlotEmploiesTempss();
	}
	@GetMapping("/{id}")
    public SlotEmploiesTemps findSlotEmploiesTempsbyid(@PathVariable Long id)
	{
		return SlotEmploiesTempsservices.findSlotEmploiesTempsbyid(id);
	}
	
}
