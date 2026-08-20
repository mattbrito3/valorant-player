package com.matdev.valorant_player.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.matdev.valorant_player.enums.Elo;
import com.matdev.valorant_player.enums.Role;
import com.matdev.valorant_player.enums.Agent;

public class CriarPlayerRequestDTO {

    @NotBlank(message = "Nickname é obrigatório")
    @Size(min = 3, max = 16)
    private String nickname;

    @NotBlank(message = "Tag é obrigatória")
    @Size(min = 2, max = 6)
    private String tag;

    @NotNull(message = "Elo é obrigatório")
    private Elo elo;

    @NotNull(message = "Role é obrigatório")
    private Role mainRole;

    @NotNull(message = "Agent é obrigatório")
    private Agent mainAgent;

    // CONSTRUTOR COM ORDEM CORRETA (igual aos campos)
    public CriarPlayerRequestDTO(
            String nickname,
            String tag,
            Elo elo,
            Role mainRole,
            Agent mainAgent
    ) {
        this.nickname = nickname;
        this.tag = tag;
        this.elo = elo;
        this.mainRole = mainRole;
        this.mainAgent = mainAgent;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTag() {
        return tag;
    }

    public Elo getElo() {
        return elo;
    }

    public Role getMainRole() {
        return mainRole;
    }

    public Agent getMainAgent() {
        return mainAgent;
    }
}