package SDA.DesignPaterns.NullObject.CurrencyExchange;

public class PLNUSDrate implements Exchangeable{
    @Override
    public Float getRate() {
        return 1/3.8f;
    }

    @Override
    public String getName() {
        return "USD";
    }
}
