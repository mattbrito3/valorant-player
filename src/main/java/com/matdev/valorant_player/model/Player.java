package com.matdev.valorant_player.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nickname não pode estar vazio")
    @Size(min = 3, max = 16)
    private String nickname;

    private String tag;
    private String rank;
    private String mainRole;
    private String mainAgent;


    public Player() {
    }

    public Player(Long id, String nickname, String rank, String mainRole, String tag, String mainAgent) {
        this.id = id;
        this.mainAgent = mainAgent;
        this.tag = tag;
        this.nickname = nickname;
        this.rank = rank;
        this.mainRole = mainRole;

    }

    public Player(String agent, String rank, String nickname, String role) {
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }
}
