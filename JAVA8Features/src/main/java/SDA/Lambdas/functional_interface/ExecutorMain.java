package SDA.Lambdas.functional_interface;

public class ExecutorMain {
    public static void main(String[] args) {

        Executor executor = (int x) ->{
            System.out.println(x+" liczba ");
        };

        executor.execute(5);
    }
}
