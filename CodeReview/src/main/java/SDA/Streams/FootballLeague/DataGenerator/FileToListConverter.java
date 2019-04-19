package SDA.Streams.FootballLeague.DataGenerator;

import SDA.Streams.FootballLeague.DataGenerator.SearchStrategy.SearchingContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileToListConverter {

    List<String> getListFromFile(String fileName, SearchingContext context) throws IOException {
        File namesCSV = new File(".\\src\\main\\java\\SDA\\Streams\\FootballLeague\\TextFiles\\"+fileName);
        LineIterator iterator = FileUtils.lineIterator(namesCSV, "UTF-8");

        List<String> result = new ArrayList<>();
        while (iterator.hasNext()){
            String newName;
            newName = context.getValue(iterator.next());
            result.add(newName);
        }
        return result;
    }
}
