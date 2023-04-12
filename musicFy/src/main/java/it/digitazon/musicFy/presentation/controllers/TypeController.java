package it.digitazon.musicFy.presentation.controllers;


import it.digitazon.musicFy.persistence.entities.Song;
import it.digitazon.musicFy.persistence.entities.Type;
import it.digitazon.musicFy.presentation.dto.SongDTO;
import it.digitazon.musicFy.presentation.dto.TypeDTO;
import it.digitazon.musicFy.services.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")

public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<TypeDTO> getTypes() {
        return typeService.getAll() //prendo oggetti Type dal db
                .stream()
                .map(this::convertToDto) //Mappo le istanze da Type a TypeDto
                .toList(); // converto in lista
        // IL DTO PURO CHE SIA UNA LISTA O CHE SIA IL SINGOLO OGGETTO, è UTILE SONO QUANDO RESTITUIAMO IL JSON
        // CON IL REST CONTROLLER
       // IN ALTRE SITUAZIONE CON USER INTERFACE DEKSTOP, POSSIAMO USARE OGGETTI ENTITA COME MODELLI, SENZA PROBLEMI DI DIPENDENZA CICLICA,
       // POICHE IL RENDERING VIENNE FATTO PRIMA DI RESTITUIRE I DATI

    }

    @GetMapping("/{id}")
    public TypeDTO getTypeById(@PathVariable long id)

    {
        return convertToDto(typeService.getById(id)) ;
    }


    @PostMapping // indica che il metodo sarà reperibile allo/types, con tipologia post
    public TypeDTO createType(@RequestBody TypeDTO newType) {
        Type type = convertToEntity(newType);
       type= typeService.create(type);
       return convertToDto(type);
    }


    @PutMapping("/{id}")
    public TypeDTO updateType(@PathVariable long id, @RequestBody TypeDTO updateType) {
        Type type = convertToEntity(updateType);
        type =typeService.update(id, type);
        return convertToDto(type);
    }


    @DeleteMapping("/{id}")
    public TypeDTO deleteType(@PathVariable long id) {
        return convertToDto(typeService.delete(id)) ;
    }

    @GetMapping("/{id}/songs")
    public List<SongDTO> getSongs(@PathVariable long id) {
       Type type = typeService.getById(id);
       return type.getSongs()
               .stream()
               .map(this::convertToSongDto)
               .toList();
    }

private TypeDTO convertToDto(Type type) {

//        Type dto = new TypeDTO();
//        dto.setId(type.getId()); // stessa cosa con il model mapper
        return modelMapper.map(type, TypeDTO.class);
}

private Type convertToEntity(TypeDTO dto) {
        return modelMapper.map(dto,Type.class);
}

private SongDTO convertToSongDto(Song song) {
        SongDTO dto = modelMapper.map(song,SongDTO.class) ;
        dto.setIdType(song.getType().getId());
        dto.setIdArtist(song.getArtist().getId());
        return dto;
}
}
