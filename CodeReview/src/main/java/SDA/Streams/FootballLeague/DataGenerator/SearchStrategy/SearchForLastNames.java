package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

public class SearchForLastNames implements SearchingContext {
    @Override
    public String getValue(String input) {
        return input.trim();
    }
}
