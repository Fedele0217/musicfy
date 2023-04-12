package it.digitazon.musicFy.configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicFyConfiguration {
@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper(); // Fa quello che noi facevamo nel service, mappa il dto alle entità e viceversa
    }
}
