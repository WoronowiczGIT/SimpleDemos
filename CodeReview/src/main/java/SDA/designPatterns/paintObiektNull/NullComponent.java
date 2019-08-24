package SDA.designPatterns.paintObiektNull;

public class NullComponent implements UIComponent {
    @Override
    public void onClick() {
        System.out.println("this aint component");
    }
}
