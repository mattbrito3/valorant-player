package com.matdev.valorant_player.dto;

import com.matdev.valorant_player.model.Player;

public class ResponsePlayerDTO {

    private Long id;
    private String nickname;
    private String elo;
    private String mainAgent;
    private String tag;
    private String mainRole;

    public ResponsePlayerDTO(Long id, String nickname, String elo, String mainAgent, String tag, String mainRole) {
        this.id = id;
        this.mainAgent = mainAgent;
        this.mainRole = mainRole;
        this.tag = tag;
        this.nickname = nickname;
        this.elo = elo;
    }

    public ResponsePlayerDTO(Player criarPlayer) {
        this.id = criarPlayer.getId();
        this.nickname = criarPlayer.getNickname();
        this.elo = criarPlayer.getRank();
    }

    public String getMainAgent() {
        return mainAgent;
    }

    public void setMainAgent(String mainAgent) {
        this.mainAgent = mainAgent;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }
}
