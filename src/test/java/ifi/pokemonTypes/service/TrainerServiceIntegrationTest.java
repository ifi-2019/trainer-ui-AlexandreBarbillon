package ifi.pokemonTypes.service;

import ifi.pokemonTypes.bo.Trainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TrainerServiceIntegrationTest {

    @Autowired
    TrainerService service;

    @Autowired
    RestTemplate restTemplate;

    @Test
    void getTrainer_returnATrainer(){
        Trainer ash = service.getTrainer("Ash");
        assertNotNull(ash);
        assertNotNull(ash.getName());
        assertNotNull(ash.getPassword());
    }
}