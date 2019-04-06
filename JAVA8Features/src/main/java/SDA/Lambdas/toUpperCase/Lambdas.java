package SDA.Lambdas.toUpperCase;

public class Lambdas {

    // f(x) = ax+b
    // (int x) -> (a*x)+b
    public static void main(String[] args) {

        String testText = "Abcde";
        //Interface implementation
        ToUpperCase tuc = new ToUpperCaseImpl();
        System.out.println("regular implementation: " + tuc.invoke(testText));

        //Embeded
        ToUpperCase tuc2 = new ToUpperCase() {
            @Override
            public String invoke(String tekst) {
                return tekst.toUpperCase();
            }
        };
        System.out.println(tuc2.invoke(testText));

        //Anonymous
        makebig(new ToUpperCase() {
            @Override
            public String invoke(String tekst) {
                System.out.println(tekst.toUpperCase());
                return tekst.toUpperCase();
            }
        });

        //Lambdas
        makebig((String tekst)->{
            System.out.println(tekst.toUpperCase());
            return tekst.toUpperCase();
        });

    }
       static void makebig(ToUpperCase tuc){ tuc.invoke("tekst");}
}

