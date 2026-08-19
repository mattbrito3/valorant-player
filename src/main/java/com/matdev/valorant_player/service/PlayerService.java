package com.matdev.valorant_player.service;

import com.matdev.valorant_player.dto.CriarPlayerRequestDTO;
import com.matdev.valorant_player.dto.ResponsePlayerDTO;
import com.matdev.valorant_player.model.Player;
import com.matdev.valorant_player.repository.PlayerRepository;
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

    public ResponsePlayerDTO criar(@RequestBody CriarPlayerRequestDTO dto) {
        Player player = new Player(dto.getMainAgent(), dto.getElo(), dto.getNickname(), dto.getMainRole());
        Player criarPlayer = playerRepository.save(player);

        return new ResponsePlayerDTO(criarPlayer);
    }


    public List<ResponsePlayerDTO> listarTodos() { //Meu metodo vai devolver uma lista de ResponsePlayerDTO
        List<Player> players = playerRepository.findAll(); // O findAll() busca no banco e me devolve uma lista de Player (entidades)
        List<ResponsePlayerDTO> dtos = new ArrayList<>(); // Crio uma lista vazia para armazenar os ResponsePlayerDTO
        for (Player player : players) { // Para cada Player encontrado...
            ResponsePlayerDTO dto = new ResponsePlayerDTO(player); // ...transformo esse Player em um ResponsePlayerDTO
            dtos.add(dto); // E adiciono o DTO na lista que vou devolver
        }
        return dtos; // Devolvo a lista de DTOs
    }
}
