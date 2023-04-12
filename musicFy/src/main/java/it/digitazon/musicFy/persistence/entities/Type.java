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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
