package com.game.manager.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Participant {
    @Id
    private Long id;
    @ManyToOne
    @ToString.Exclude private Encounter encounter;

    private String name;
    private int init;
    private int maxHp;
    private int currentHp;
    private int armorClass;
    private String description;
}
