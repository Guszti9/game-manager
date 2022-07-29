package com.game.manager.controller;

import com.game.manager.model.Creature;
import com.game.manager.model.UserMember;
import com.game.manager.service.CreatureService;
import com.game.manager.service.EncounterService;
import com.game.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CreatureController {
    private final CreatureService creatureService;

    @Autowired
    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("api/creature/{id}")
    public Creature geCreatureById(@PathVariable Long id) {
        return creatureService.getCreatureById(id);
    }

    @GetMapping("api/creature/all")
    public List<Creature> getAllCreature() {
        return creatureService.getAllCreature();
    }

    @PostMapping("api/creature")
    public void addCreature(@RequestBody Creature creature) {
        creatureService.addCreature(creature);
    }

    @PutMapping("api/creature/{id}")
    public void editCreature(@PathVariable Long id, @RequestBody Creature creature) {
        creatureService.editCreature(id, creature);
    }

    @DeleteMapping("api/creature/{id}")
    public void deleteCreature(@PathVariable Long id) {
        creatureService.deleteCreature(id);
    }
}
