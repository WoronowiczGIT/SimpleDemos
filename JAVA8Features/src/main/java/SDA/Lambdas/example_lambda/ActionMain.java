package SDA.Lambdas.example_lambda;

public class ActionMain {
    public static void main(String[] args) {
        //Sposób 1
        Action action = new ActionImpl();
        //action.execute(20, 30);
        executeAnonymousImpl(action);

        //Sposób 2
        Action action1 = new Action() {
            @Override
            public void execute(int x, int y) {
                System.out.println("Execute v2 - embedded: " + x + ", " + y);
            }

            @Override
            public void execute() {

            }
        };
        //action1.execute(20, 30);
        executeAnonymousImpl(action1);

        //Sposób 3
        executeAnonymousImpl(new Action() {
            @Override
            public void execute(int x, int y) {
                System.out.println("Execute v3 - anonymous: " + x + ", " + y);
            }

            @Override
            public void execute() {
                System.out.println("test");
            }
        });
    }

    public static void executeAnonymousImpl(Action action) {
        action.execute(20,30);
        action.execute();
    }
}
