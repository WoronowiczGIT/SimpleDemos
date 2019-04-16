package SDA.Streams.FootballLeague;

public class Name {
    private String name;
    private Float Frequency;
    private Float howMany;
    private Integer rank;

    public Name(String name, Float frequency, Float howMany, Integer rank) {
        this.name = name;
        Frequency = frequency;
        this.howMany = howMany;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

}
