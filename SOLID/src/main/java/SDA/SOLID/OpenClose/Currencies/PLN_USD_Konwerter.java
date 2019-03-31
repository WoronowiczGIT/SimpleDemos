package SDA.SOLID.OpenClose.Currencies;

import SDA.SOLID.OpenClose.Currencies.CurrencyPairs;
import SDA.SOLID.OpenClose.Currencies.KonwerterInterface;

public class PLN_USD_Konwerter implements KonwerterInterface {
    @Override
    public Double konwert(Double money) {
        return CurrencyPairs.PLN_USD.getRates()*money;
    }
}
