package it.digitazon.musicFy.presentation.dto;

import org.modelmapper.internal.bytebuddy.asm.MemberSubstitution;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ArtistDTO {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long id;
    private String name;
    private String alias;
    private boolean isDeleted;

    private String birthDate;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Date convertBirthDate()  {
        if(this.birthDate == null || this.birthDate.length() == 0){
            return null;
        }
        try {
            return dateFormat.parse(this.birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public void convertDateToString(Date date) {
        if (date == null) {
            this.birthDate = null;
        } else {
            this.birthDate = dateFormat.format(date);
        }
    }
}