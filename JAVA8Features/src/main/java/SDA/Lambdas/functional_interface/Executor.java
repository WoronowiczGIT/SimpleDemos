package SDA.Lambdas.functional_interface;

@FunctionalInterface // <- informujemy developerów, że w tym interfejsie nie moze byc wiecej  metod
public interface Executor {
    void execute(int x);

}
