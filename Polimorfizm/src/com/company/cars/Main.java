package com.company.cars;

public class Main {
    public static void main(String[] args) {
        Samochod bmw = new Samochod();
        WarsztatNadwozia warsztat = new WarsztatNadwozia();
        warsztat.napraw(bmw);
        WarsztatLakierniczy lakiernia = new WarsztatLakierniczy();
        lakiernia.lakieruj(bmw);
        bmw.pobierzKolor();
        warsztat.maluj(bmw);
    }
}
