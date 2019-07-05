package com.company.calculator;

public abstract class Operacja {

    double liczba1;
    double liczba2;

    Operacja(double liczba1, double liczba2){
     this.liczba1 = liczba1;
     this.liczba2 = liczba2;
    }

    void wyswietlWynik() {
        System.out.println(wykonajOperacje(liczba1, liczba2));
    }

    abstract double wykonajOperacje(double liczba1, double liczba2);
}
