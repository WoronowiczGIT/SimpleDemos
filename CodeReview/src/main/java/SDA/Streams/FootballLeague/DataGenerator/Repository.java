package SDA.Streams.FootballLeague.DataGenerator;

import SDA.Streams.FootballLeague.DataGenerator.SearchStrategy.*;


import java.io.IOException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repository {
    private List<String> names;
    private List<String> lastNames;
    private List<String> nationalities;
    private List<String> clubNames;
    private List<String> countries;
    private FileToListConverter adapter;

    public Repository() throws IOException {
        this.names = new ArrayList<>();
        this.lastNames = new ArrayList<>();
        this.nationalities = new ArrayList<>();
        this.clubNames = new ArrayList<>();
        this.countries = new ArrayList<>();
        this.adapter = new FileToListConverter();
        setUP();
    }

    void setUP() throws IOException {
        names = adapter.getListFromFile("names.txt", new SearchForNames());
        lastNames = adapter.getListFromFile("lastNames.txt", new SearchForLastNames());
        nationalities = adapter.getListFromFile("nationalities.txt", new SearchForNationalities());
        clubNames = adapter.getListFromFile("clubNames.txt", new SearchForClubNames());
        countries = adapter.getListFromFile("nationalities.txt", new SearchForCountry());
    }

    public static Object getRandomValueFromList(List list) {
        Random random = new Random();
        Integer scope = list.size();
        Integer position = random.nextInt(scope);
        return list.get(position);
    }

    public static LocalDate getRandomBirthDay() {
        Random random = new Random();
        int day = random.nextInt(364)+1;
        int minimumAge = 20;
        int maximumAge = 55;
        int lastYearPossible = LocalDate.now().getYear() - minimumAge;
        int year = lastYearPossible - random.nextInt(maximumAge-minimumAge);
        LocalDate birthDate = LocalDate.ofYearDay(year, day);
        return birthDate;
    }

    public List<String> getNames() {
        return names;
    }
    public List<String> getLastNames() {
        return lastNames;
    }
    public List<String> getNationalities() {
        return nationalities;
    }
    public List<String> getClubNames() {
        return clubNames;
    }
    public List<String> getCountries() {
        return countries;
    }


}
