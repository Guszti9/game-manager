package com.game.manager.service;

import com.game.manager.model.Participant;
import com.game.manager.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantService {
    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant getParticipantById(Long id) {
        return participantRepository.getById(id);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }

    public void updateParticipant(Long id, Participant changedData) {
        Participant participant = participantRepository.getById(id);
        participant.editParticipant(changedData);
        participantRepository.save(participant);
    }
}
