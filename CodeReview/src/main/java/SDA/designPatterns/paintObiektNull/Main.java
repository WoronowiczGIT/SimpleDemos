package SDA.designPatterns.paintObiektNull;

public class Main {

    public static void main(String[] args) {

        UIComponentFactory factory = new UIComponentFactory();

        factory.createComponent("JSON").onClick();
        factory.createComponent("button").onClick();
    }
}
