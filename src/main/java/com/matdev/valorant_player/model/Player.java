package com.matdev.valorant_player.model;

import com.matdev.valorant_player.enums.Elo;
import com.matdev.valorant_player.enums.Role;
import com.matdev.valorant_player.enums.Agent;

import jakarta.persistence.*;

import java.util.Locale;

@Entity
@Table(
        name = "Player",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nickname", "tag"})
)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String tag;

    @PrePersist
    @PreUpdate
    private void normalizeFields() {
        if (nickname != null) {
            nickname = nickname.trim().toLowerCase(Locale.ROOT);
        }

        if (tag != null) {
            tag = tag.trim();
            if (!tag.startsWith("#")) {
                tag = "#" + tag;
            }
            tag = tag.toUpperCase(Locale.ROOT);
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Elo elo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role mainRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Agent mainAgent;


    public Player() {
    }

    public Player(Agent mainAgent, Role mainRole, Elo elo, String tag, String nickname, Long id) {
        this.mainAgent = mainAgent;
        this.mainRole = mainRole;
        this.elo = elo;
        this.tag = tag;
        this.nickname = nickname;
        this.id = id;
    } // dois construtores, um com id e outro sem id, precisamos de 3 construtores, um com 5 parametros, 6 e um vazio.ma

    public Player(Agent mainAgent, Role mainRole, Elo elo, String tag, String nickname) {
        this.mainAgent = mainAgent;
        this.mainRole = mainRole;
        this.elo = elo;
        this.tag = tag;
        this.nickname = nickname;
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
