package com.matdev.valorant_player.dto;

public class CriarPlayerRequestDTO {
    private String nickname;
    private String elo;
    private String role;
    private String agent;

    public CriarPlayerRequestDTO(String nickname, String role, String elo, String agent) {
        this.nickname = nickname;
        this.role = role;
        this.elo = elo;
        this.agent = agent;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
