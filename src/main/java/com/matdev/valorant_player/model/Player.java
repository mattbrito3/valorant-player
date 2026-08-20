package com.matdev.valorant_player.model;
import com.matdev.valorant_player.enums.Elo;
import com.matdev.valorant_player.enums.Role;
import com.matdev.valorant_player.enums.Agent;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String tag;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Elo elo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Role mainRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Agent mainAgent;


    public Player() {
    }

    public Player(Agent mainAgent, Role mainRole, Elo elo, String tag, String nickname, Long id) {
        this.mainAgent = mainAgent;
        this.mainRole = mainRole;
        this.elo = elo;
        this.tag = tag;
        this.nickname = nickname;
        this.id = id;
    }

    public Player(Agent mainAgent, Role mainRole, Elo elo, String tag, String nickname) {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Elo getElo() {
        return elo;
    }

    public void setElo(Elo elo) {
        this.elo = elo;
    }

    public Role getMainRole() {
        return mainRole;
    }

    public void setMainRole(Role mainRole) {
        this.mainRole = mainRole;
    }

    public Agent getMainAgent() {
        return mainAgent;
    }

    public void setMainAgent(Agent mainAgent) {
        this.mainAgent = mainAgent;
    }
}
