package com.game.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.manager.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
