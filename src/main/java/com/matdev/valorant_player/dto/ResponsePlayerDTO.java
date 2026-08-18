package com.matdev.valorant_player.dto;

import com.matdev.valorant_player.model.Player;

public class ResponsePlayerDTO {

    private Long id;
    private String nickname;
    private String elo;

    public ResponsePlayerDTO(Long id, String nickname, String elo) {
        this.id = id;
        this.nickname = nickname;
        this.elo = elo;
    }

    public ResponsePlayerDTO(Player criarPlayer) {
        this.id = criarPlayer.getId();
        this.nickname = criarPlayer.getNickname();
        this.elo = criarPlayer.getRank();
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
