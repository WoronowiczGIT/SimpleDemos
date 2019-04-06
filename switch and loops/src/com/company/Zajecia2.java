package com.company;

import java.util.Arrays;

public class Zajecia2 {
    public static void main(String[] args) {


    }

    // PETLE FOR,WHILE, I TABLICE
    public void printingNamesUsingWhile() {
        String[] tab = {"jacek ", "jacek ", "jacek "};
        tab[0] = "jacek ";
        tab[1] = "ma ";
        tab[2] = "kota ";

        int counter = 0;
        while (counter < tab.length) {
            System.out.print(tab[counter] + " ");
            counter++;
        }

        System.out.println(tab[0] + tab[1] + tab[2]);
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
    }

    // printing elements using for and foreach loop
    public void printingNumbers() {
        double wynik = 0;
        int[] oceny = {3, 5, 3, 2, 5, 4, 5, 5, 3, 3, 4, 4, 4, 5};

        for (int i = 0; i < oceny.length; i++) {
            wynik += oceny[i];
        }
        // foreach loop
        System.out.println("For each");
        for (int ocena : oceny) {
            System.out.print(ocena + " ");
        }

        System.out.println();
        // for loop
        for (int i = (oceny.length - 1); i >= 0; i--) {
            System.out.print(oceny[i] + " ");
        }

    }

    public void printingNamesUsingForEach() {
        String[] imiona = {"jacek", "piotrek", "marta", "olga", "jan", "brajanusz"};

        for (String imie : imiona) {
            System.out.print(imie + " ");
        }
    }

    public void printingAvarage(int wynik, int[] oceny) {
        System.out.println("srednia ocen to: " + Math.round(wynik / oceny.length));
        System.out.println("suma ocen to: " + wynik);
        System.out.println(Arrays.toString(oceny));
    }

    public void breakAndContinueStatements() {
        for (int i = 0; i < 1000; i++) {

            if (checkingFor666(i)) {
                System.out.println("tych nie lubimy");
                break;
            }
            if (i % 2 != 0) {
                System.out.println(i);
                continue;
            }
        }
    }

    public boolean checkingFor666(int i) {
        return i == 666;
    }

    public void printingGivenCases() {
        for (int i = 100; i >= 0; i--) {
            switch (i) {
                case 9:
                    System.out.println("tej nie lubie");
                    break;
                case 13:
                    System.out.println("tej nie pocałuje");
                    break;
                case 0:
                    System.out.println("ZERO");
                    break;
                default:
                    System.out.println("lubie: " + i);
                    break;
            }
        }
    }

    public void ifElseStatements() {
        for (int i = 100; i >= 0; i--) {
            int znak = i;
            int liczba1 = 9;
            int liczba2 = 13;

            if (znak < 60) {
                znak += 60;
            }

            if (i == liczba1 || i == liczba2) {
                System.out.println("Tej nie lubie");
            } else if (i == 0) {
                System.out.println("null  " + i);
            } else if (i % 2 == 0) {
                System.out.println("even " + (char) znak + " " + i);
            } else System.out.println("odd " + (char) znak + " " + i);
        }
    }

    public void evenOdd() {
        int number = 100;
        do {
            System.out.print(number);
            if (number % 2 == 0) {
                System.out.println("  even");
            } else System.out.println("  Odd");
            number--;
        } while (number >= 1);
    }

    public void countDebt() {
        int suma = 0;
        int dlug = 1000;
        int oprocentowanie = 20;
        int liczbaMiesiecy = 0;
        int expectedProfit = 1000;

        do {
            suma += dlug * oprocentowanie;
            liczbaMiesiecy++;
        } while (suma < expectedProfit);
        System.out.println("liczba miesiecy: " + liczbaMiesiecy);
    }

    public void doAndDoWhileLoops(){
        int counter = 0;

        do{
            System.out.println("do while counter: "+ counter);
        }while(counter!=0);

        while(counter!=0){
            System.out.println("while counter: "+counter);
        }
    }

}
