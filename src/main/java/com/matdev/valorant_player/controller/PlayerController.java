package com.matdev.valorant_player.controller;

import com.matdev.valorant_player.dto.CriarPlayerRequestDTO;
import com.matdev.valorant_player.dto.ResponsePlayerDTO;
import com.matdev.valorant_player.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponsePlayerDTO buscarPlayer(@PathVariable Long id) {
        return playerService.buscarPlayer(id);
    }

    @GetMapping()
    public ResponseEntity<List<ResponsePlayerDTO>> listarPlayers() {
        return ResponseEntity.ok(playerService.listarTodos());
    }


    @PostMapping()
    public ResponseEntity<ResponsePlayerDTO> criar(@Valid @RequestBody CriarPlayerRequestDTO dto) {
        ResponsePlayerDTO playerCriado = playerService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(playerCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsePlayerDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody CriarPlayerRequestDTO dto) {
        return ResponseEntity.ok(playerService.atualizar(id, dto));
    }
}
