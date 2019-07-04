package SDA.designPatterns.pokedex;

public class Pokedex {
    private Pokemon[] list = new Pokemon[2];
    private int lastPokemonIndex = 0;

    public void addPokemon(Pokemon pokemon){
    checkSize();
    list[lastPokemonIndex] = pokemon;
    lastPokemonIndex++;
    }

    public Piterator createPiterator(){
        return new Piterator();
    }

    private void checkSize(){
        int lastIndex = list.length-1;
        if(lastPokemonIndex == lastIndex){
            Pokemon[] newList = new Pokemon[list.length*2];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
    }
    public class Piterator{
        private int index = 0;

        private Piterator(){}

        public Pokemon next(){
            if(!hasNext()) return null;
            return list[index++];
        }
        public boolean hasNext(){
            return index < lastPokemonIndex;
        }

    }
}
