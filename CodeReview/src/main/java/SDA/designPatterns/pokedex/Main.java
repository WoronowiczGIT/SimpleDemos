package SDA.designPatterns.pokedex;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Pokedex dexter = new Pokedex();
        dexter.addPokemon(new Pokemon("Pikachu"));
        dexter.addPokemon(new Pokemon("Bulbasaur"));
        dexter.addPokemon(new Pokemon("Charizard"));

        Iterator<Pokemon> piterator = dexter.createPiterator();

        while (piterator.hasNext()){
            System.out.println(piterator.next().getName());
        }
    }
}
