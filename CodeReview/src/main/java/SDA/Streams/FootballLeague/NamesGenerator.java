package SDA.Streams.FootballLeague;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.*;

public class NamesGenerator {
    private List<String> allNames = new LinkedList<>();

    void readFile(String fileName) throws IOException {
        File namesCSV = new File(".\\src\\main\\java\\SDA\\Streams\\FootballLeague\\"+fileName);
        LineIterator iterator = FileUtils.lineIterator(namesCSV, "UTF-8");

        while (iterator.hasNext()){
            String newName;
            newName = getNames(iterator.nextLine());
            allNames.add(newName);
        }

    }

    String getNames(String line) {
        String name = "";
        for (int i = 0; i < line.length(); i++) {
            if (isLetter(line.charAt(i))) {
                name += line.charAt(i);
            }
        }
        return name;
    }
    void addName(){}

    String getRandomName(){
        Random random = new Random();
        Integer scoope = allNames.size();
        Integer position = random.nextInt(scoope);
        return allNames.get(position);
    }

    public static void main(String[] args) throws IOException {
        NamesGenerator ng = new NamesGenerator();
        ng.readFile();
        System.out.println(ng.getRandomName());

    }


}
