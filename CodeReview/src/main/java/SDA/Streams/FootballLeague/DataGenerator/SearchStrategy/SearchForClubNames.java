package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

public class SearchForClubNames implements SearchingContext {
    @Override
    public String getValue(String input) {
        String[] clubName = input.split("-");
        return clubName[0];
    }
}
