package SDA.DesignPaterns.NullObject.CurrencyExchange;

public class PLNEURrate implements Exchangeable {
    @Override
    public Float getRate() {
        return 1/4.3f;
    }

    @Override
    public String getName() {
        return "EUR";
    }
}
