package com.game.manager.service;

import com.game.manager.model.Creature;
import com.game.manager.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreatureService {
    private final CreatureRepository creatureRepository;

    @Autowired
    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public Creature getCreatureById(Long id) {
        return creatureRepository.getById(id);
    }

    public List<Creature> getAllCreature() {
        return creatureRepository.findAll();
    }

    public Long addCreature(Creature creature) {
        return creatureRepository.save(creature).getId();
    }

    public void editCreature(Long id, Creature data) {
        Creature creature = creatureRepository.getById(id);
        creature.editCreature(data);
        creatureRepository.save(creature);
    }

    public void deleteCreature(Long id) {
        creatureRepository.deleteById(id);
    }
}
