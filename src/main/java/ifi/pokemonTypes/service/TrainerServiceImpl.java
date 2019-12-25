package ifi.pokemonTypes.service;

import ifi.pokemonTypes.bo.PokemonType;
import ifi.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    private RestTemplate restTemplate;
    private String trainerServiceUrl;

    @Override
    public List<Trainer> getTrainers() {
        var res = restTemplate.getForObject(trainerServiceUrl+"/trainers/",Trainer[].class);
        return Arrays.asList(res);
    }

    @Override
    public Trainer getTrainer(String userName) {
        List<Trainer> trainers = getTrainers();
        for(Trainer trainer: trainers){
            if(trainer.getName().equals(userName)){
                return trainer;
            }
        }
        return null;
    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setPokemonTypeServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }


}
