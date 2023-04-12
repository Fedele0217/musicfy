package it.digitazon.musicFy.persistence.repositories;

import it.digitazon.musicFy.persistence.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
