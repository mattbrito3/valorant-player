package com.matdev.valorant_player.repository;

import com.matdev.valorant_player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByNicknameIgnoreCaseAndTagIgnoreCase(String nickname, String tag);
}
