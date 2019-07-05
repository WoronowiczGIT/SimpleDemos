package com.company.calculator;

public class Main {
    public static void main(String[] args) {

        WiekszaLiczba w = new WiekszaLiczba(2, 5);
        w.wyswietlWynik();
        MniejszaLiczba m = new MniejszaLiczba(2, 5);
        m.wyswietlWynik();
        Odejmowanie o = new Odejmowanie(5, 1);
        o.wyswietlWynik();
        System.out.println(o.wykonajOperacje(6,6));
    }
}
