package ifi.pokemonTypes.service;

import ifi.pokemonTypes.bo.PokemonType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();
    PokemonType getPokemonById(int id);
    public void setRestTemplate(RestTemplate restTemplate);
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl);
}
