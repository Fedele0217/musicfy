package it.digitazon.musicFy.services;

import it.digitazon.musicFy.persistence.entities.Song;
import it.digitazon.musicFy.presentation.dto.SongDTO;
import it.digitazon.musicFy.presentation.dto.TypeDTO;
import it.digitazon.musicFy.persistence.entities.Type;
import it.digitazon.musicFy.persistence.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAll() { // tradforma oggetti di tipo entità in tipo di oggetti dto
        return typeRepository.findAll();
    }

    public Type getById(long id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        if (optionalType.isEmpty()) {
            throw new IllegalStateException("Type not found");
        }
        return optionalType.get();
    }

    public Type create(Type newType) {
        newType = typeRepository.save(newType);
        // salvo entity e il metodo mi restituisce
        // una nuova istanza con id generato
        // Assegno al dto il nuovo id generato dal salvataggio
        return newType;  //restituisco al controller il dto con il nuovo id
    }

    public Type update(long id, Type updateType) {
        Optional<Type> optionalType = typeRepository.findById(id); // cerco entità da aaggiornare tramite id
        if (optionalType.isEmpty()) { // se non esiste restituisco vuoto
            throw new IllegalStateException("Entity non found");
        }
        Type entityToUpdate = optionalType.get(); // se esiste lo prendo dall'optioonal
        updateType.setId(entityToUpdate.getId()); // valorizzo id nel dto
        updateType = typeRepository.save(updateType); // salvo entità nel db

        return updateType; //restituisco il dto aggiornato
    }

    public Type delete(long id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        if (optionalType.isEmpty()) { // se non esiste restituisco vuoto
            throw new IllegalStateException("Entity non found");
        }
        Type entityToDelete = optionalType.get();
        typeRepository.delete(entityToDelete);
        return entityToDelete;
    }

//    public List<SongDTO> getSong (long idType){ // ci restituisce la canzone collegata ad un tipo
//        Optional<Type> optionalType=typeRepository.findById(idType);
//        if(optionalType.isEmpty()) {
//            throw new IllegalStateException("entity not foung");
//        }
//        Type entity = optionalType.get();
//        List<Song> typeSongs= entity.getSongs();
//        return typeSongs.stream().map(song->{
//            SongDTO dto = new SongDTO();
//            dto.setId(song.getId());
//            dto.setName(song.getName());
//            dto.setDuration(song.getDuration());
//            dto.setIdType(song.getType().getId()); // uso il getId dopo perche all'interno di type ho dei get a cui posso accedere
//            dto.setIdArtist(song.getArtist().getId());
//            return dto;
//        }).toList();
//    }

}


