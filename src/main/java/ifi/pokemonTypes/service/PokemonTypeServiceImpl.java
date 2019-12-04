package ifi.pokemonTypes.service;

import ifi.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    public List<PokemonType> listPokemonsTypes() {
        var res = restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/",PokemonType[].class);
        Arrays.sort(res, new Comparator<PokemonType>() {
            @Override
            public int compare(PokemonType pokemonType, PokemonType t1) {
                return Integer.compare(pokemonType.getId(), t1.getId());
            }
        });
        return Arrays.asList(res);
    }

    @Override
    public PokemonType getPokemonById(int id) {
        var res = restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/"+id,PokemonType.class);
        return res;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
