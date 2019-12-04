package ifi.pokemonTypes.bo;

import java.util.List;

public class ExtendedTrainer {

    Trainer trainer;
    private List<PokemonTypeLevel> pokemonTeam;

    public ExtendedTrainer(Trainer trainer, List<PokemonTypeLevel> pokemonTeam) {
        this.trainer = trainer;
        this.pokemonTeam = pokemonTeam;
    }

    public void setTeam(List<Pokemon> team) {

    }

    public List<PokemonTypeLevel> getPokemonTypeTeam(){
        return this.pokemonTeam;
    }

    public void setPokemonTypeTeam(List<PokemonTypeLevel> pokemonTypeList){
        this.pokemonTeam = pokemonTypeList;
    }
}
