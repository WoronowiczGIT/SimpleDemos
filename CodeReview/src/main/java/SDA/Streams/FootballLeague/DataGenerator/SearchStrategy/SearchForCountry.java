package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.util.stream.Stream;

import static java.lang.Character.isLetter;

public class SearchForCountry implements SearchingContext {
    @Override
    public String getValue(String input) {
        Boolean isCountry = validateCountryFormat(input);
        String out = "";

        if (isCountry) {
            for (int i = 0; i < input.length(); i++) {
                if (isLetter(input.charAt(i))) {
                    out += input.charAt(i);
                }
            }
            return out;
        } else return "England";
    }

    Boolean validateCountryFormat(String input) {
        Boolean isCountry = true;
        for (int i = 0; i < 5; i++) {
            if (!isLetter(input.charAt(i))) {
                isCountry = false;
            }
        }
        return isCountry;
    }
}
