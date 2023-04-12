package it.digitazon.musicFy.services;


import it.digitazon.musicFy.persistence.entities.Artist;
import it.digitazon.musicFy.persistence.entities.Song;
import it.digitazon.musicFy.persistence.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAll() {
        return songRepository.findAll();
    }


    public Song getById(long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }
        return optionalSong.get();
    }

    public Song create(Song newsong) {
        if (newsong.getArtist() == null || newsong.getType() == null) {
            throw new IllegalStateException("Artist and type not be null");
        }
        newsong = songRepository.save(newsong);
        return newsong;
    }

    public Song update(long id, Song updatesong) {
        if (updatesong.getArtist() == null || updatesong.getType() == null) {
            throw new IllegalStateException("Artist and type not be null");
        }
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isEmpty()) {
            throw new IllegalStateException("Entity not found");
        }
        Song entityToUpdate = optionalSong.get();
        updatesong.setId(entityToUpdate.getId());
        updatesong = songRepository.save(updatesong);
        return updatesong;
    }


    public Song delete(long id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isEmpty()) {
            throw new IllegalStateException("Entity not found");

        }
        Song entityToDelete = song.get();
        songRepository.delete(entityToDelete);
        return entityToDelete;
    }
}

