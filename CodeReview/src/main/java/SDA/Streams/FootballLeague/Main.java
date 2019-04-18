package SDA.Streams.FootballLeague;

import SDA.Streams.FootballLeague.DataGenerator.Fasada;
import SDA.Streams.FootballLeague.DataGenerator.Generator;
import SDA.Streams.FootballLeague.Models.FootballLeague;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static SDA.Streams.FootballLeague.DataGenerator.Fasada.getRandomBirthDay;
import static SDA.Streams.FootballLeague.DataGenerator.Fasada.getRandomValueFromList;

public class Main {
    public static void main(String[] args) throws IOException {

        Generator g = new Generator();
        List<FootballLeague> leagues = g.generateListOfLeagues(10);



        Stream.of(liga).flatMap(footballLeague -> footballLeague.getTeams().stream())
                .forEach(footballTeam -> System.out.println(footballTeam.getManager()
                        .getName()));
//        3.1. Na podstawie wszystkich dostępnych lig zwróć wszystkich treneerów
//        3.2. Na podstawie wszystkich dostępnych lig zwróć nazwiska wszystkich trenenerów mających co najmniej 50 lat
//        3.3. Na podstawie wszystkich dostępnych lig zwróć wszystkich trenenerów mających co najwyżej 30 lat
//        3.4. Na podstawie wszystkich dostępnych lig zwróć wszystkich trenenerów narodowości niemieckiej
//        3.5. Na podstawie wszystkich dostępnych lig zwróć wszystkich piłkarzy
//        3.6. Na podstawie wszystkich dostępnych lig zwróć wszystkich piłkarzy - atakujacych
//        3.7.  Na podstawie wszystkich dostępnych lig zwróć imiona wszystkich piłkarzy - obrońców mających mniej niż 30 lat
//        3.8. Na podstawie wszystkich dostępnych lig zwróć wszystkich piłkarzy - bramkarzy mających co najmniej 50 lat
//        3.9. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby
//        3.10. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby zawierające co najmniej 2 piłkarzy
//        3.11. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby mające trenera narodowości brazyliskiej
//        3.12. Na podstawie wszystkich dostępnych lig zwróć wszystkie polskie kluby
//        3.13. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby mające ponad 50 lat
//        3.14. Na podstawie wszystkich dostępnych lig zwróć wszystkie te które zawierają w swoich rozgrywkach co najmniej 3 zespoły
//        3.15. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby pierwszoligowe (level == 1)

    }
}
