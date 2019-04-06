package SDA.Lambdas.toUpperCase;

public class ToUpperCaseImpl implements ToUpperCase {
    @Override
    public String invoke(String tekst) {
        return  tekst.toUpperCase();
    }
}
