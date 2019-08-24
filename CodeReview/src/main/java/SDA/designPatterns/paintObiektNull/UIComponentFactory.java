package SDA.designPatterns.paintObiektNull;

public class UIComponentFactory {

    public UIComponent createComponent(String type) {

        if ("CheckBox".equalsIgnoreCase(type)) {
            return new CheckBox();
        }
        if ("Button".equalsIgnoreCase(type)) {
            return new MyButton();
        }
        return new NullComponent();
    }
}
