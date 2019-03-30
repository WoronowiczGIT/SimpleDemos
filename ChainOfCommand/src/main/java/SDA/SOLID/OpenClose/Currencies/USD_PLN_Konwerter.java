package SDA.SOLID.OpenClose.Currencies;

import SDA.SOLID.OpenClose.Currencies.CurrencyPairs;
import SDA.SOLID.OpenClose.Currencies.KonwerterInterface;

public class USD_PLN_Konwerter implements KonwerterInterface {
    @Override
    public Double konwert(Double money) {
        return CurrencyPairs.USD_PLN.getRates() * money;
    }
}
