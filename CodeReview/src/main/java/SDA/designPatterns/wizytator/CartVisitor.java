package SDA.designPatterns.wizytator;

public interface CartVisitor {

    int visit(Laptop laptop);
    int visit(WashingMashine washingMashine);
}
