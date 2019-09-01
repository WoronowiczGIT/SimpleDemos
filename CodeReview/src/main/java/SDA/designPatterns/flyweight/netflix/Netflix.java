package SDA.designPatterns.flyweight.netflix;

import java.util.HashMap;
import java.util.Map;

public class Netflix {
    // change map for file
    private Map<String,Movie> cachedMovies = new HashMap<>();

    public Movie getMovie(String title) throws InterruptedException {

        Movie movie =  cachedMovies.get(title);

        if(movie==null){
            switch (title){
                case "BackToTheFuture":{
                    movie = new MovieImplementation("BackToTheFuture");
                    break;
                }
                case "WildWildWest":{
                    movie = new MovieImplementation("WildWildWest");
                    break;
                }
                case "DarkTower":{
                    movie = new MovieImplementation("DarkTower");
                    break;
                }
                default:{
                    System.out.println("no such movie in offer");
                    return null;
                }
            }
            cachedMovies.put(title,movie);
            return movie;
        }else{
            return movie;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Netflix n = new Netflix();

        Movie myMovie = n.getMovie("DarkTower");
        myMovie.showMovie();

        myMovie = n.getMovie("BackToTheFuture");
        myMovie.showMovie();

        myMovie = n.getMovie("DarkTower");
        myMovie.showMovie();

        myMovie = n.getMovie("XXX");
        myMovie.showMovie();
    }
}
