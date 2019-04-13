package SDA.functional_interface.Function;

@FunctionalInterface // <- informujemy developerów, że w tym interfejsie nie moze byc wiecej  metod
public interface Executor {
    void execute(int x);

}
