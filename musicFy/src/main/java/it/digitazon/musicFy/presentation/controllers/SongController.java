package it.digitazon.musicFy.presentation.controllers;


import it.digitazon.musicFy.persistence.entities.Artist;
import it.digitazon.musicFy.persistence.entities.Song;
import it.digitazon.musicFy.persistence.entities.Type;
import it.digitazon.musicFy.presentation.dto.ArtistDTO;
import it.digitazon.musicFy.presentation.dto.SongDTO;
import it.digitazon.musicFy.presentation.dto.TypeDTO;
import it.digitazon.musicFy.services.ArtistService;
import it.digitazon.musicFy.services.SongService;
import it.digitazon.musicFy.services.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {


    @Autowired
    private SongService songService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ModelMapper modelMapper;



    @GetMapping
    public List<SongDTO> getSongs(){
        return songService.getAll()
                .stream().map(this::convertToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public SongDTO getArtistById(@PathVariable long id) {
        return convertToDto(songService.getById(id));
    }


    @PostMapping
    public SongDTO createSong(@RequestBody SongDTO newSong){
        Song song = convertToEntity(newSong);
        song = songService.create(song);
        return  convertToDto(song);
    }

    @PutMapping("/{id}")
    public  SongDTO updateSong ( @PathVariable long id, @RequestBody SongDTO updateSong ){
        Song song = convertToEntity(updateSong);
        song = songService.update(id,song);
        return  convertToDto(song);




        }
    @DeleteMapping("/{id}")
    public SongDTO deleteSong (@PathVariable long id){
        return convertToDto(songService.delete(id));
    }



    private SongDTO convertToDto(Song song){
        return modelMapper.map(song, SongDTO.class);
        }
    private Song convertToEntity(SongDTO dto){
        Song song = modelMapper.map(dto,Song.class);
        Type songType= typeService.getById(dto.getIdType());
        Artist songArtist = artistService.getById(dto.getIdArtist());

        song.setArtist(songArtist);
        song.setType(songType);
        return song;
    }

    private ArtistDTO convertToArtistDTO(Artist artist){
        return modelMapper.map(artist,ArtistDTO.class);
    }

    private TypeDTO convertToTypeDto(Type type ){
        return modelMapper.map(type,TypeDTO.class);
    }

    @GetMapping("/{id}/artist")
    public ArtistDTO getArtist(@PathVariable long id){
        Song song = songService.getById(id);
        return convertToArtistDTO(song.getArtist());



    }
    @GetMapping("/{id}/type")
    public TypeDTO getType(@PathVariable long id) {
        Song song = songService.getById(id);
        return convertToTypeDto(song.getType());
    }
}
