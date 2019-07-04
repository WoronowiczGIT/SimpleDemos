package SDA.designPatterns.pokedex;

public class Main {
    public static void main(String[] args) {
        Pokedex dexter = new Pokedex();
        dexter.addPokemon(new Pokemon("Pikachu"));
        dexter.addPokemon(new Pokemon("Bulbasaur"));
        dexter.addPokemon(new Pokemon("Charizard"));

        Pokedex.Piterator piterator = dexter.createPiterator();

        while (piterator.hasNext()){
            System.out.println(piterator.next().getName());
        }
    }
}
