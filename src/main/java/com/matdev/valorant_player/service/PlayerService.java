package com.matdev.valorant_player.service;

import com.matdev.valorant_player.dto.CriarPlayerRequestDTO;
import com.matdev.valorant_player.dto.ResponsePlayerDTO;
import com.matdev.valorant_player.model.Player;
import com.matdev.valorant_player.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ResponsePlayerDTO buscarPlayer (Long id){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player não encontrado"));

        return new ResponsePlayerDTO(player);
    }

    public ResponsePlayerDTO criar(@RequestBody CriarPlayerRequestDTO dto) {
        Player player = new Player(dto.getAgent(), dto.getElo(), dto.getNickname(), dto.getRole());
        Player criarPlayer = playerRepository.save(player);

        return new ResponsePlayerDTO(criarPlayer);
    }
}
