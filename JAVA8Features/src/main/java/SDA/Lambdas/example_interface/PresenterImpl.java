package SDA.Lambdas.example_interface;

public class PresenterImpl implements Presenter {
    @Override
    public void present(String text) {
        System.out.println("Twój prezenter: " + text);
    }
}
