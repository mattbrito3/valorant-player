package com.matdev.valorant_player.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String rank;
    private String mainRole;
    private Integer level;

    public Player () {}

    public Player(Long id, String nickname, String rank, String mainRole, Integer level) {
        this.id = id;
        this.nickname = nickname;
        this.rank = rank;
        this.mainRole = mainRole;
        this.level = level;
    }

    public Player(String agent, String elo, String nickname, String role) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
