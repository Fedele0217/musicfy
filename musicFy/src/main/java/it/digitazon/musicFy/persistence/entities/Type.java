package it.digitazon.musicFy.persistence.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="types")
public class Type {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // fa autoincrement
    private long id;

@Column(name="name",nullable = false)
    private String name;

@Column(name = "is_deleted", nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
private boolean isDeleted;
@OneToMany(mappedBy = "type")
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
