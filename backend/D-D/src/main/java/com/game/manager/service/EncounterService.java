package com.game.manager.service;

import com.game.manager.model.Encounter;
import com.game.manager.model.Participant;
import com.game.manager.repository.EncounterRepository;
import com.game.manager.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EncounterService {
    private EncounterRepository encounterRepository;
    private ParticipantRepository participantRepository;

    @Autowired
    public EncounterService(EncounterRepository encounterRepository, ParticipantRepository participantRepository) {
        this.encounterRepository = encounterRepository;
        this.participantRepository = participantRepository;
    }


    public Encounter getEncounterById(Long id) {
        return encounterRepository.getById(id);
    }

    public List<Encounter> getAllEncounter() {
        return encounterRepository.findAll();
    }

    public void addEncounter(Encounter encounter) {
        encounterRepository.save(encounter);
    }

    public void addParticipant(long id, Participant participant) {
        Encounter encounter = encounterRepository.getById(id);
        participant.setEncounter(encounter);
        Participant saveParticipant = participantRepository.save(participant);
        encounter.addParticipant(saveParticipant);
        encounterRepository.save(encounter);
    }

    public List<Participant> getEncountersParticipants(Long id) {
        Encounter encounter = encounterRepository.getById(id);
        return encounter.getParticipants();
    }
}
