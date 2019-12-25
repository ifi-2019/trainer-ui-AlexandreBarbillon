package ifi.controller;

import ifi.pokemonTypes.bo.*;
import ifi.pokemonTypes.service.PokemonTypeService;
import ifi.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainerController {
    private PokemonTypeService pts;
    private TrainerService ts;
    @GetMapping("/trainers")
    public ModelAndView trainerList(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("trainers");
        List<Trainer> trainers = ts.getTrainers();
        List<ExtendedTrainer> unwrappedTrainers = new ArrayList<>();
        for(Trainer trainer : trainers){
            List<Pokemon> pokemons = trainer.getTeam();
            List<PokemonTypeLevel> pokemonsUnwrapped = unwrapPokemons(pokemons);
            unwrappedTrainers.add(new ExtendedTrainer(trainer,pokemonsUnwrapped));
        }
        mav.addObject("trainers",unwrappedTrainers);
        return mav;
    }

    @GetMapping("/profile")
    public ModelAndView profile(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        SecurityContext context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        Trainer trainer = ts.getTrainer(name);
        mav.addObject("user",trainer);
        return mav;
    }

    private List<PokemonTypeLevel> unwrapPokemons(List<Pokemon> pokemons){
        /**
         * Convert pokemons id/level to full pokemon stat / level
         */
        List<PokemonTypeLevel> pokemonsUnwrapped = new ArrayList<>();
        for(Pokemon pokemon : pokemons){
            PokemonType pokemonType = pts.getPokemonById(pokemon.getPokemonTypeId());
            PokemonTypeLevel pokemonTypeLevel = new PokemonTypeLevel(pokemonType, pokemon.getLevel());
            pokemonsUnwrapped.add(pokemonTypeLevel);
        }
        return pokemonsUnwrapped;
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pts = pokemonTypeService;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService){
        this.ts = trainerService;
    }
}
