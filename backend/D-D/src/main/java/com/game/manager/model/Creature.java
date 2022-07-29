package com.game.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.manager.model.enums.Attribute;
import com.game.manager.model.enums.Skill;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Creature {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="type")
    @ToString.Exclude
    @JsonIgnore
    private List<Participant> participants = new ArrayList<>();

    private String name;
    private int health;
    private int wisdomMod;
    private int constitutionMod;
    private int dexterityMod;
    private int intelligenceMod;
    private int charismaMod;
    private int strengthMod;
    @ElementCollection(targetClass=Enum.class)
    private List<Attribute> saves;
    @ElementCollection(targetClass=Enum.class)
    private List<Skill> skills;
    private int armorClass;
    private String description;

    public void editCreature(Creature creature) {
        this.name = creature.name;
        this.health = creature.health;
        this.wisdomMod = creature.wisdomMod;
        this.constitutionMod = creature.constitutionMod;
        this.dexterityMod = creature.dexterityMod;
        this.intelligenceMod = creature.intelligenceMod;
        this.charismaMod = creature.charismaMod;
        this.strengthMod = creature.strengthMod;
        this.saves = creature.saves;
        this.skills = creature.skills;
        this.armorClass = creature.armorClass;
        this.description = creature.description;
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }
}
