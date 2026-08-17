package com.matdev.valorant_player.controller;

import com.matdev.valorant_player.dto.CriarPlayerRequestDTO;
import com.matdev.valorant_player.dto.ResponsePlayerDTO;
import com.matdev.valorant_player.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/agents")
public class PlayerController {

    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponsePlayerDTO buscarPlayer(@PathVariable Long id) {
        return playerService.buscarPlayer(id);
    }


    @PostMapping("/players")
    public ResponseEntity<ResponsePlayerDTO> criar(@RequestBody CriarPlayerRequestDTO dto) {
        ResponsePlayerDTO playerCriado = playerService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(playerCriado);
    }
}
