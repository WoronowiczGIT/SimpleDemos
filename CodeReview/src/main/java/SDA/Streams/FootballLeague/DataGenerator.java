package SDA.Streams.FootballLeague;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    public class FootballPlayer {
        private String name;
        private String lastName;
        private String position;
        private LocalDate dateOfBirth;
    }

    public class FootballManager {
        private String name;
        private String lastName;
        private String nationality;
        private LocalDate dateOfBirth;
    }


    public class FootballTeam {
        private String name;
        private List<FootballPlayer> players;
        private FootballManager manager;
        private int age; //wiek klubu
    }

    public class FootballLeage {
        private String name;
        private String country;
        private int level; //poziom rozgrywek
        private List<FootballTeam> teams;
    }
//    String[] names = Arrays.asList("Tomek","Maciek","","Ronaldo","Rivaldo","Brian","Maciek");
//
//   FootballLeage getLeague(){
//
//    }
//
//   FootballTeam getTeam(){
//
//    }
//
//   FootballManager getMenager(){
//
//   }
//
//   FootballPlayer getPlayer(){
//
//   }

}
