package SDA.designPatterns.wizytator;

public interface ItemElement {

    int accept(CartVisitor cartVisitor);
}
