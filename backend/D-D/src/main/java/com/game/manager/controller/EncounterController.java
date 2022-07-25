package com.game.manager.controller;

import com.game.manager.model.Encounter;
import com.game.manager.model.Participant;
import com.game.manager.service.EncounterService;
import com.game.manager.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EncounterController {
    private final EncounterService encounterService;
    private final ParticipantService participantService;

    @Autowired
    public EncounterController(EncounterService encounterService, ParticipantService participantService) {
        this.encounterService = encounterService;
        this.participantService = participantService;
    }

    @GetMapping("api/encounter/{id}")
    public Encounter getEncounterById(@PathVariable int id){
        return encounterService.getEncounterById(id);
    }

    @GetMapping("api/encounter/all")
    public List<Encounter> getAllEncounter() {
        return encounterService.getAllEncounter();
    }

    @PostMapping("api/encounter/{id}")
    public void addEncounter(@PathVariable int id) {
        encounterService.addEncounter(id);
    }

    @PutMapping("api/encounter/{id}")
    public
}
