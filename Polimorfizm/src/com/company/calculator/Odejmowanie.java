package com.company.calculator;

public class Odejmowanie implements Operacja {
    @Override
    public double oblicz(double liczba1, double liczba2) {
        return liczba1-liczba2;
    }
}
