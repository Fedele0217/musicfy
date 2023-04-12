package it.digitazon.musicFy.persistence.repositories;

import it.digitazon.musicFy.persistence.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository <Type,Long> {

}
