package com.learn.fantasy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by stepanferubko
 */
@Entity
@Table
public class League implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LeagueMember> leagueMembers;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<LeagueMember> getLeagueMembers() {
        return leagueMembers;
    }

    public void setLeagueMembers(List<LeagueMember> leagueMembers) {
        this.leagueMembers = leagueMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        League league = (League) o;

        if (id != league.id) return false;
        if (name != null ? !name.equals(league.name) : league.name != null) return false;
        if (createdDate != null ? !createdDate.equals(league.createdDate) : league.createdDate != null) return false;
        return leagueMembers != null ? leagueMembers.equals(league.leagueMembers) : league.leagueMembers == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (leagueMembers != null ? leagueMembers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LeagueVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", leagueMembers=" + leagueMembers +
                '}';
    }
}
