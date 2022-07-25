package com.game.manager.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Encounter {
    @Id
    private Long id;
    @OneToMany(mappedBy="encounter")
    private List<Participant> participants;
}
