package it.digitazon.musicFy.presentation.dto;

public class SongDTO {
    private long id;
    private String name;
    private Integer duration;

    private long idArtist;
    private long idType;


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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public long getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(long idArtist) {
        this.idArtist = idArtist;
    }

    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
    }
}
