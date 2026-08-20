package com.matdev.valorant_player.dto;

import com.matdev.valorant_player.model.Player;
import com.matdev.valorant_player.enums.Elo;
import com.matdev.valorant_player.enums.Role;
import com.matdev.valorant_player.enums.Agent;

public class ResponsePlayerDTO {

    private Long id;
    private String nickname;
    private Elo elo;
    private Agent mainAgent;
    private String tag;
    private Role mainRole;


    public ResponsePlayerDTO(Player criarPlayer) {
        this.id = criarPlayer.getId();
        this.nickname = criarPlayer.getNickname();
        this.elo = criarPlayer.getElo();
    }

    public ResponsePlayerDTO(Long id, String nickname, Elo elo, Agent mainAgent, String tag, Role mainRole) {
        this.id = id;
        this.nickname = nickname;
        this.elo = elo;
        this.mainAgent = mainAgent;
        this.tag = tag;
        this.mainRole = mainRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Elo getElo() {
        return elo;
    }

    public void setElo(Elo elo) {
        this.elo = elo;
    }

    public Agent getMainAgent() {
        return mainAgent;
    }

    public void setMainAgent(Agent mainAgent) {
        this.mainAgent = mainAgent;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Role getMainRole() {
        return mainRole;
    }

    public void setMainRole(Role mainRole) {
        this.mainRole = mainRole;
    }
}
