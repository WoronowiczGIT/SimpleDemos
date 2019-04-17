package SDA.Streams.FootballLeague;

import SDA.Streams.FootballLeague.DataGenerator.Fasada;
import SDA.Streams.FootballLeague.DataGenerator.Generator;
import SDA.Streams.FootballLeague.Models.FootballLeague;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Stream;

import static SDA.Streams.FootballLeague.DataGenerator.Fasada.getRandomBirthDay;
import static SDA.Streams.FootballLeague.DataGenerator.Fasada.getRandomValueFromList;

public class Main {
    public static void main(String[] args) throws IOException {

        Generator g = new Generator();
        FootballLeague liga = g.generateLeague(6);

        Stream.of(liga).flatMap(footballLeague -> footballLeague.getTeams().stream()).forEach(footballTeam -> System.out.println(footballTeam.getManager().getName()));

    }
}
