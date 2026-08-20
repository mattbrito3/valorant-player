package com.matdev.valorant_player.service;

import com.matdev.valorant_player.dto.CriarPlayerRequestDTO;
import com.matdev.valorant_player.dto.ResponsePlayerDTO;
import com.matdev.valorant_player.model.Player;
import com.matdev.valorant_player.repository.PlayerRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ResponsePlayerDTO buscarPlayer(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player não encontrado"));

        return new ResponsePlayerDTO(player);
    }

    public ResponsePlayerDTO criar(@Valid @RequestBody CriarPlayerRequestDTO dto) {
        Player player = new Player(
                        dto.getMainAgent(),
                        dto.getMainRole(),
                dto.getElo(),
                dto.getTag(),
                dto.getNickname());
        Player playerSalvo =  playerRepository.save(player);

        return new ResponsePlayerDTO(playerSalvo);
    }


    public List<ResponsePlayerDTO> listarTodos() { //Meu metodo vai devolver uma lista de ResponsePlayerDTO
        return playerRepository.findAll()
                .stream() // transforma a lista em fluxo
                .map(ResponsePlayerDTO::new)// converte CADA player pra DTO
                .toList(); // retorna a lista
    }
}
