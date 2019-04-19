package SDA.Streams.FootballLeague.DataGenerator;

import SDA.Streams.FootballLeague.Models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static SDA.Streams.FootballLeague.DataGenerator.Repository.getRandomBirthDay;
import static SDA.Streams.FootballLeague.DataGenerator.Repository.getRandomValueFromList;

public class Generator {
    private Repository repository;

    public Generator() throws IOException {
        this.repository = new Repository();
        repository.setUP();
    }

    public List<FootballLeague> generateLeagues(int numberOfLeagues) {
        List<FootballLeague> leagues = new ArrayList<>();

        while (numberOfLeagues > leagues.size()) {
            leagues.add(new FootballLeague());
        }
        leagues.stream().forEach(league -> {
            league.setName(getRandomValueFromList(repository.getCountries()) + "LEAGUE!");
            league.setCountry((String) getRandomValueFromList(repository.getCountries()));
            league.setLevel(new Random().nextInt(3) + 1);
            league.setTeams(generateTeams(new Random().nextInt(10) + 10));
        });
        return leagues;
    }
    List<FootballTeam> generateTeams(int numberOfTeams) {
        List<FootballTeam> teams = new ArrayList<>();

        while (numberOfTeams > teams.size()) {
            teams.add(new FootballTeam());
        }
        teams.stream().forEach(team -> {
            try {
                team.setAge(new Random().nextInt(100) + 1);
                team.setName((String) getRandomValueFromList(repository.getClubNames()));
                team.setManager(generateMenager());
                team.setPlayers(getTeamTogether());
            } catch (IOException e) {
                System.out.println("error while creating team " + team.getName());
            }
        });
        return teams;
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

    FootballPlayer generatePlayer() throws IOException {
        String name = (String) getRandomValueFromList(repository.getNames());
        String lastName = (String) getRandomValueFromList(repository.getLastNames());
        LocalDate dateOfBirth = getRandomBirthDay();

        return new FootballPlayer(name, lastName, Position.NULLPOSITION, dateOfBirth);
    }
    FootballMenager generateMenager() throws IOException {
        String name = (String) getRandomValueFromList(repository.getNames());
        String lastName = (String) getRandomValueFromList(repository.getLastNames());
        String nationality = (String) getRandomValueFromList(repository.getNationalities());
        LocalDate dateOfBirth = getRandomBirthDay();

        return new FootballMenager(name, lastName, nationality, dateOfBirth);
    }






}
