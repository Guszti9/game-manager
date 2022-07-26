package com.game.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Encounter encounter;

    private String name;
    private int init;
    private int maxHp;
    private int currentHp;
    private int armorClass;
    private String description;

    public void editParticipant(Participant participant) {
        this.name = participant.getName();
        this.init = participant.getInit();
        this.maxHp = participant.getMaxHp();
        this.currentHp = participant.getCurrentHp();
        this.armorClass = participant.getArmorClass();
        this.description = participant.getDescription();
    }
}
