package SDA.designPatterns.flyweight.netflix;

public class MovieImplementation implements Movie {
    private String title;

    public MovieImplementation(String title) throws InterruptedException {
        System.out.println("BUFFORING");
        Thread.sleep(5000);
        this.title = title;
    }

    @Override
    public void showMovie() throws InterruptedException {
        System.out.println("now plaing: "+title );
        Thread.sleep(3000);
        System.out.println("THE END");
    }
}
