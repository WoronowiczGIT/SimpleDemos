package com.company.instruments;

public class Concert {
    public static void main(String[] args) {
        Instrument[] band = {
                new Guitar(),
                new Drums(),
                new ElectricGuitar(),
                new Bass()
        };

        for (Instrument i: band) {
            i.play();
        }
    }
}

interface Instrument{
    void play();
}

class Guitar implements Instrument{
    @Override
    public void play() {
        System.out.println("plaing "+ getClass().getSimpleName());
    }
}

class Drums implements Instrument{

    @Override
    public void play() {
        System.out.println("plaing "+ getClass().getSimpleName());
    }
}

class Bass extends Guitar{
    public void play(){
        System.out.println("pretend plaing "+ getClass().getSimpleName());
    }
}

class ElectricGuitar extends Guitar{
    ElectricGuitar(){
        System.out.println("connect to powergrid");
    }
}

