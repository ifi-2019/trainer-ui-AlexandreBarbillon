package ifi.pokemonTypes.bo;

import java.util.List;

public class PokemonTypeLevel extends PokemonType {
    private PokemonType pokemonType;
    int level;

    public PokemonTypeLevel(PokemonType pokemonType, int level){
        this.pokemonType = pokemonType;
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int getId() { return pokemonType.getId(); }
    @Override
    public void setId(int id) {
        pokemonType.setId(id);
    }
    @Override
    public int getBaseExperience() {
        return pokemonType.getBaseExperience();
    }
    @Override
    public void setBaseExperience(int baseExperience) { pokemonType.setBaseExperience(baseExperience); }
    @Override
    public int getHeight() { return pokemonType.getHeight(); }
    @Override
    public void setHeight(int height) {
        pokemonType.setHeight(height);
    }
    @Override
    public String getName() {
        return pokemonType.getName();
    }
    @Override
    public void setName(String name) {
        pokemonType.setName(name);
    }
    @Override
    public Sprites getSprites() { return pokemonType.getSprites(); }
    @Override
    public void setSprites(Sprites sprites) {
        pokemonType.setSprites(sprites);
    }
    @Override
    public Stats getStats() {
        return pokemonType.getStats();
    }
    @Override
    public void setStats(Stats stats) {
        pokemonType.setStats(stats);
    }
    @Override
    public int getWeight() {
        return pokemonType.getWeight();
    }
    @Override
    public void setWeight(int weight) {
        pokemonType.setWeight(weight);
    }
    @Override
    public List<String> getTypes() {
        return pokemonType.getTypes();
    }
    @Override
    public void setTypes(List<String> types) {
        pokemonType.setTypes(types);
    }
}
