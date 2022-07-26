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

    @Autowired
    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @GetMapping("api/encounter/{id}")
    public Encounter getEncounterById(@PathVariable Long id){
        return encounterService.getEncounterById(id);
    }

    @GetMapping("api/encounter/{id}/participant/all")
    public List<Participant> getEncountersParticipants(@PathVariable Long id){
        return encounterService.getEncountersParticipants(id);
    }

    @GetMapping("api/encounter/all")
    public List<Encounter> getAllEncounter() {
        return encounterService.getAllEncounter();
    }

    @PostMapping("api/encounter")
    public void addEncounter(@RequestBody Encounter encounter) {
        encounterService.addEncounter(encounter);
    }

    @PostMapping("api/encounter/{id}/participant")
    public void addParticipant(@PathVariable Long id, @RequestBody Participant participant) {
        encounterService.addParticipant(id, participant);
    }

    @DeleteMapping("api/encounter/{id}")
    public void deleteEncounter(@PathVariable Long id) {
        encounterService.deleteEncounter(id);
    }
}
