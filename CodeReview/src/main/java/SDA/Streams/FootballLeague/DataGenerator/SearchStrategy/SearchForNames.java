package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.util.Locale;

import static java.lang.Character.isLetter;

public class SearchForNames implements SearchingContext {
    /** Explanation: the names.txt contains a lot of unnecessary meta data,
     *  so we just fetch the first available sequence of letters in each line.
     ** @param input
     * @return
     */
    @Override
    public String getValue(String input) {
        String name = "";
        for (int i = 0; i < input.length(); i++) {
            if (isLetter(input.charAt(i))) {
                name += input.charAt(i);
            }else break;
        }
        name = formatName(name);
        return name;
    }

    String formatName (String name){
        String out="";
        if(!name.isEmpty()) {
             out = name.charAt(0)+ name.substring(1).toLowerCase();
        }
        return out;
    }
}
