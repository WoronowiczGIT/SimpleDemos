package SDA.DesignPaterns.NullObject.CurrencyExchange;

public class NULLrate implements Exchangeable{
    @Override
    public Float getRate() {
        return 0f;
    }

    @Override
    public String getName() {
        return "nothing";
    }
}
