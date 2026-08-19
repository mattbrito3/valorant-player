package com.matdev.valorant_player.dto;

public class CriarPlayerRequestDTO {
    private String nickname;
    private String elo;
    private String tag;
    private String mainRole;
    private String mainAgent;

    public CriarPlayerRequestDTO(String nickname, String mainRole, String elo, String mainAgent,  String tag) {
        this.nickname = nickname;
        this.mainRole = mainRole;
        this.tag = tag;
        this.elo = elo;
        this.mainAgent = mainAgent;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }

    public String getMainAgent() {
        return mainAgent;
    }

    public void setMainAgent(String mainAgent) {
        this.mainAgent = mainAgent;
    }
}
