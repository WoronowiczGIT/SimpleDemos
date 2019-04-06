package com.company;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        double a = 0;
        double b = 0;
        double wynik = 0;
        char operacja;

        System.out.print("pierwsza liczba: ");
        a = skaner.nextDouble();

        System.out.print("\noperacja: ");
        operacja = skaner.next().charAt(0);

        System.out.print("\ndruga liczba: ");
        b = skaner.nextDouble();
      //  System.out.println("\n");
        switch (operacja) {
            case '+':
                wynik = a + b;
                break;
            case '-':
                wynik = a - b;
                break;
            case '*':
                wynik = a * b;
                break;
            case '/':
                wynik = a / b;
                break;
            case '^':
                wynik = a * a;
                break;
            case '%':
                wynik = a % b;
                break;
            default:
                System.out.println("niewłaściwy operator uzyj: +,-,*,/,^,%");
        }
        System.out.println(wynik);
    }
}
