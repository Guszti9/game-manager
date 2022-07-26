package com.game.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Encounter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy="encounter")
    private List<Participant> participants = new ArrayList<>();
    private String name;

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }
}
