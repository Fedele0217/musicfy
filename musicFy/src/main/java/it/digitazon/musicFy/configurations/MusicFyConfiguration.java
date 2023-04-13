package it.digitazon.musicFy.configurations;


import it.digitazon.musicFy.persistence.entities.Artist;
import it.digitazon.musicFy.persistence.entities.Type;
import it.digitazon.musicFy.presentation.dto.ArtistDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicFyConfiguration {
@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper(); // Fa quello che noi facevamo nel service, mappa il dto alle entità e viceversa

    TypeMap<Artist, ArtistDTO> propertyMapper = modelMapper.createTypeMap(Artist.class, ArtistDTO.class);
    propertyMapper.addMapping(Artist::getBirthDate, ArtistDTO::convertDateToString);


    TypeMap<ArtistDTO, Artist> propertyMapperDTO = modelMapper.createTypeMap(ArtistDTO.class, Artist.class);
    propertyMapperDTO.addMapping(ArtistDTO::convertBirthDate, Artist::setBirthDate);

    return modelMapper;

    }
}
