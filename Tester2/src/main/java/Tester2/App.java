package Tester2;

import javafx.application.Application;
import javafx.stage.Stage;
import Tester2.controllers.MainViewController;
import Tester2.views.MainView;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static MainView view;
    public static MainViewController controller;
    public static TestRunner runner;
    public static void main( String[] args )
    {
        view = new MainView();
        runner = new TestRunner();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        view.display(primaryStage);
        controller = new MainViewController(view, runner);

    }
}
