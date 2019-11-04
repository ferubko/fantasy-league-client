package com.learn.fantasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by stepanferubko
 */
@Entity
@Table
public class Team implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name")

    private String name;
    @Column(name = "shortName")

    private String shortName;
    @Column(name = "strength")

    private Integer strength;

//    @OneToMany( mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//
//    @LazyCollection(
//            LazyCollectionOption.EXTRA
//    )
//    private Set<PlayerVO> players= new HashSet<>();

    public Team(Long id) {
        this.id = id;
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

//    public Set<PlayerVO> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(Set<PlayerVO> players) {
//        this.players = players;
//    }
//
//    public TeamVO addPlayer(PlayerVO  player) {
//        players.add(player);
//        player.setTeam(this);
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != null ? !id.equals(team.id) : team.id != null) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (shortName != null ? !shortName.equals(team.shortName) : team.shortName != null) return false;
        return (strength != null ? !strength.equals(team.strength) : team.strength != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (strength != null ? strength.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", strength=" + strength +
//                ", players=" + players +
                '}';
    }
}

