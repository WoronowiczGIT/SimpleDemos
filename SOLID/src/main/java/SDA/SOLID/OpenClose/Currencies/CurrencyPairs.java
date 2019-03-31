package SDA.SOLID.OpenClose.Currencies;

public enum CurrencyPairs {
    USD_PLN(3.0), PLN_USD(0.3),
    USD_EU(0.9), EU_USD(1.1),
    PLN_GBP(0.2), GBP_PLN(5.0);

    private double rates;

    CurrencyPairs(double rates) {
        this.rates = rates;
    }

    public double getRates() {
        return rates;
    }
}
