package ifi.pokemonTypes.service;

import ifi.pokemonTypes.bo.PokemonType;
import ifi.pokemonTypes.bo.Trainer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface TrainerService {

    List<Trainer> getTrainers();
    public void setRestTemplate(RestTemplate restTemplate);
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl);
}
