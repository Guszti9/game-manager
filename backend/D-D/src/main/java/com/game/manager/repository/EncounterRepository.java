package com.game.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.manager.model.Encounter;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Long> {

}
