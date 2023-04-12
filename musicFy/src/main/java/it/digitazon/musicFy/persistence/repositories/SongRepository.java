package it.digitazon.musicFy.persistence.repositories;

import it.digitazon.musicFy.persistence.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository <Song,Long> {
}
