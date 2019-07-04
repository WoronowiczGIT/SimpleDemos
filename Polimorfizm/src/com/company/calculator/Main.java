package com.company.calculator;

public class Main {
    public static void main(String[] args) {
        Kalkulator[] tab = Kalkulator.values();

        double liczba1 = 3;
        double liczba2 = 3;
        String testZnak = "^";

        double result = Kalkulator
                            .znajdzKalkulatorDlaZnaku(testZnak)
                            .oblicz(liczba1,liczba2);

        for (Kalkulator element : tab
        ) {
            if (testZnak.equals(element.znak)) {
                System.out.println(element);
                double wynik = element.operacja.oblicz(liczba1, liczba2);
                System.out.println(wynik);
            }
        }


    }
}
