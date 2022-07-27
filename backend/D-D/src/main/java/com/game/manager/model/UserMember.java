package com.game.manager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UserMember {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String passWorld;

    public void editUser(UserMember user) {
        this.name = user.name;
        this.email = user.email;
        this.passWorld = user.passWorld;
    }
}