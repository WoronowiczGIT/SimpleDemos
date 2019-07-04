package com.company.cars;

import com.company.cars.Nadwozie;

public class WarsztatNadwozia {

    void napraw(Nadwozie samochod){
        samochod.naprawBlache();
        samochod.wymienSzyby();

    }
    void maluj(Nadwozie samochod){
        samochod.przemalujNaCzerwono();
    }
}
