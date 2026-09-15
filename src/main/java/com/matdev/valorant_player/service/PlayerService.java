package com.matdev.valorant_player.service;

import com.matdev.valorant_player.dto.CriarPlayerRequestDTO;
import com.matdev.valorant_player.dto.ResponsePlayerDTO;
import com.matdev.valorant_player.model.Player;
import com.matdev.valorant_player.repository.PlayerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Locale;

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

    private String normalizarNickname(String nickname) {
        return nickname == null ? null : nickname.trim().toLowerCase(Locale.ROOT);
    }

    private String normalizarTag(String tag) {
        if (tag == null) {
            return null;
        }

        String valor = tag.trim();
        if (!valor.startsWith("#")) {
            valor = "#" + valor;
        }

        return valor.toUpperCase(Locale.ROOT);
    }

    public ResponsePlayerDTO criar(@Valid @RequestBody CriarPlayerRequestDTO dto) {
        String nicknameNormalizado = normalizarNickname(dto.getNickname());
        String tagNormalizada = normalizarTag(dto.getTag());

        if (playerRepository.findByNicknameIgnoreCaseAndTagIgnoreCase(nicknameNormalizado, tagNormalizada).isPresent()) {
            throw new RuntimeException("Player já existe");
        }

        Player player = new Player(
                dto.getMainAgent(),
                dto.getMainRole(),
                dto.getElo(),
                tagNormalizada,
                nicknameNormalizado
        );

        Player playerSalvo = playerRepository.save(player);
        return new ResponsePlayerDTO(playerSalvo);
    }

    public ResponsePlayerDTO atualizar(Long id, @Valid @RequestBody CriarPlayerRequestDTO dto) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player não encontrado"));

        String nicknameNormalizado = normalizarNickname(dto.getNickname());
        String tagNormalizada = normalizarTag(dto.getTag());

        playerRepository.findByNicknameIgnoreCaseAndTagIgnoreCase(nicknameNormalizado, tagNormalizada)
                .filter(playerExistente -> !playerExistente.getId().equals(id))
                .ifPresent(playerExistente -> {
                    throw new RuntimeException("Player já existe");
                });

        player.setNickname(nicknameNormalizado);
        player.setTag(tagNormalizada);
        player.setElo(dto.getElo());
        player.setMainRole(dto.getMainRole());
        player.setMainAgent(dto.getMainAgent());

        Player playerAtualizado = playerRepository.save(player);
        return new ResponsePlayerDTO(playerAtualizado);
    }

    public List<ResponsePlayerDTO> listarTodos() { //Meu metodo vai devolver uma lista de ResponsePlayerDTO
        return playerRepository.findAll()
                .stream() // transforma a lista em fluxo
                .map(ResponsePlayerDTO::new)// converte CADA player pra DTO
                .toList(); // retorna a lista
    }

    public void deletar(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player não encontrado"));
        playerRepository.delete(player);
    }
}
