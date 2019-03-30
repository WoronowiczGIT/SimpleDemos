package SDA.SOLID.OpenClose.Currencies;

public class Main {
    public static void main(String[] args) {

        USD_PLN_Konwerter usd_pln_konwerter = new USD_PLN_Konwerter();
        PLN_USD_Konwerter plnUSD = new PLN_USD_Konwerter();

        double pln = plnUSD.konwert(300D);
        double usd = usd_pln_konwerter.konwert(500D);

        System.out.println(usd);
        System.out.println(pln);
    }
}
