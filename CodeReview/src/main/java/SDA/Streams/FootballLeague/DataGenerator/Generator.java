package SDA.Streams.FootballLeague.DataGenerator;

import SDA.Streams.FootballLeague.Models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static SDA.Streams.FootballLeague.DataGenerator.Fasada.getRandomBirthDay;
import static SDA.Streams.FootballLeague.DataGenerator.Fasada.getRandomValueFromList;

public class Generator {
    private Fasada fasada;

    public Generator() throws IOException {
        this.fasada = new Fasada();
        fasada.setUP();
    }

    FootballPlayer generatePlayer() throws IOException {
        String name = (String) getRandomValueFromList(fasada.getNames());
        String lastName = (String) getRandomValueFromList(fasada.getLastNames());
        LocalDate dateOfBirth = getRandomBirthDay();

        return new FootballPlayer(name, lastName, Position.NULLPOSITION, dateOfBirth);
    }

    FootballMenager generateMenager() throws IOException {
        String name = (String) getRandomValueFromList(fasada.getNames());
        String lastName = (String) getRandomValueFromList(fasada.getLastNames());
        String nationality = (String) getRandomValueFromList(fasada.getNationalities());
        LocalDate dateOfBirth = getRandomBirthDay();

        return new FootballMenager(name, lastName, nationality, dateOfBirth);
    }

    FootballTeam generateTeam() throws IOException {
        String clubName = (String) getRandomValueFromList(fasada.getClubNames());
        FootballMenager menager = generateMenager();
        Integer age = new Random().nextInt(100);
        List<FootballPlayer> players = getTeamTogether();

        return new FootballTeam(clubName, players, menager, age);
    }

    List<FootballPlayer> getTeamTogether() throws IOException {
        List<FootballPlayer> list = new ArrayList<>();

        int teamSize = 11;
        while (list.size() < teamSize) {
            FootballPlayer player = generatePlayer();
            Position position = choosePosition(list);
            player.setPosition(position);
            list.add(player);
        }
        return list;
    }

    Position choosePosition(List<FootballPlayer> list) {
        int maxGoalKeepers = 1;
        int maxAttackers = 3;

        long goalKeepers = list.stream()
                .map(footballPlayer -> footballPlayer.getPosition())
                .filter(position -> position.equals(Position.GOALKEEPER))
                .count();

        long attackers = list.stream()
                .map(footballPlayer -> footballPlayer.getPosition())
                .filter(position -> position.equals(Position.ATTACK))
                .count();

        if (goalKeepers < maxGoalKeepers) return Position.GOALKEEPER;
        if (attackers < maxAttackers) return Position.ATTACK;

        Random random = new Random();
        int value = random.nextInt(10);
        if (value < 7) return Position.MIDFIELD;
        else return Position.DEFENCE;
    }

    FootballLeague generateLeague(int numberOfClubs) throws IOException {

        String country = (String) getRandomValueFromList(fasada.getCountries());
        String name = country + " LEAGUE!";
        Integer lvl = new Random().nextInt(3) + 1;

        List<FootballTeam> teams = new ArrayList<>();
        while (teams.size() < numberOfClubs) {
            teams.add(generateTeam());
        }
        FootballLeague league = new FootballLeague(name,country,lvl,teams);
        return league;
    }

    public List<FootballLeague> generateListOfLeagues(int numberOfLeagues) throws IOException {
        List<FootballLeague> leagues = new ArrayList<>();
        Random random = new Random();
        while(leagues.size() < numberOfLeagues){
            int teamsPerLeague = random.nextInt(10)+8;
            leagues.add(generateLeague(teamsPerLeague));
        }
        return leagues;
    }


}
