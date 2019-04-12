package SDA.DesignPaterns.NullObject.CurrencyExchange;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AppController ac = new AppController();

        System.out.println("chose rate: ");
        String rateName = sc.next();

        Exchangeable rate = ac.getRate(rateName);

        System.out.println("chose amount: ");
        Float amount = sc.nextFloat();

        Float result = ac.exchange(rate,amount);

        System.out.println("you bought :" + result +" "+rate.getName());
    }
}
