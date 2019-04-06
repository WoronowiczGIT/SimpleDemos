package SDA.Lambdas.example_lambda;

public class ActionImpl implements Action{
    @Override
    public void execute(int x, int y) {
        System.out.println("Execute: " + x + ", " + y + "->" +
                ActionImpl.class.getSimpleName());
    }

    @Override
    public void execute() {

    }
}
