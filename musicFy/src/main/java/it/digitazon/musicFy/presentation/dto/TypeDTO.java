package it.digitazon.musicFy.presentation.dto;

public class TypeDTO {
    private long id;
    private String name;
    private boolean isDeleted;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setName(String name) {
        this.name = name;
    }
}
