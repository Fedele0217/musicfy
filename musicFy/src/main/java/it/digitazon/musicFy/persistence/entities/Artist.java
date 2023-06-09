package it.digitazon.musicFy.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isDeleted;
    @Column(name="alias")
    private String alias;

    @Column(name = "birth_date")
    private Date birthDate;


    @OneToMany(mappedBy="artist")
    private List<Song> songs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
