package com.matdev.valorant_player.repository;

import com.matdev.valorant_player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository
        extends JpaRepository<Player, Long> {

}
