package com.game.manager.service;

import com.game.manager.model.Creature;
import com.game.manager.model.Encounter;
import com.game.manager.model.Participant;
import com.game.manager.repository.CreatureRepository;
import com.game.manager.repository.EncounterRepository;
import com.game.manager.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EncounterService {
    private final EncounterRepository encounterRepository;
    private final ParticipantRepository participantRepository;
    private final CreatureRepository creatureRepository;

    @Autowired
    public EncounterService(
            EncounterRepository encounterRepository,
            ParticipantRepository participantRepository,
            CreatureRepository creatureRepository) {
        this.encounterRepository = encounterRepository;
        this.participantRepository = participantRepository;
        this.creatureRepository = creatureRepository;
    }


    public Encounter getEncounterById(Long id) {
        return encounterRepository.getById(id);
    }

    public List<Encounter> getAllEncounter() {
        return encounterRepository.findAll();
    }

    public List<Participant> getEncountersParticipants(Long id) {
        Encounter encounter = encounterRepository.getById(id);
        return encounter.getParticipants();
    }

    public void addEncounter(Encounter encounter) {
        encounterRepository.save(encounter);
    }

    public void addParticipant(long encId, Long crtId, Participant participant) {
        Encounter encounter = encounterRepository.getById(encId);
        Creature creature = creatureRepository.getById(crtId);
        participant.setEncounter(encounter);
        participant.setType(creature);

        Participant saveParticipant = participantRepository.save(participant);

        encounter.addParticipant(saveParticipant);
        encounterRepository.save(encounter);
        creature.addParticipant(saveParticipant);
        creatureRepository.save(creature);
    }

    public void deleteEncounter(long id) {
        encounterRepository.deleteById(id);
    }
}
