package com.game.manager.controller;

import com.game.manager.model.Encounter;
import com.game.manager.model.Participant;
import com.game.manager.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ParticipantController {
    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("api/participant/{id}")
    public Participant getParticipantById(@PathVariable Long id){
        return participantService.getParticipantById(id);
    }

    @DeleteMapping("api/participant/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }

    @PutMapping("api/participant/{id}")
    public void updateParticipant(@PathVariable Long id, @RequestBody Participant participant) {
        participantService.updateParticipant(id, participant);
    }
}
