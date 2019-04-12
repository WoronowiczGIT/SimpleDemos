package SDA.DesignPaterns.NullObject.CurrencyExchange;

public class AppController {

    public Exchangeable getRate(String arg){
        arg = arg.toUpperCase();

        switch (arg){
            case "PLNUSD":
                return new PLNUSDrate();
            case "PLNEUR":
                return new PLNEURrate();
            default:
                return new NULLrate();
        }
    }

    public Float exchange(Exchangeable rate, Float amount){
        return  rate.getRate()*amount;
    }
}
