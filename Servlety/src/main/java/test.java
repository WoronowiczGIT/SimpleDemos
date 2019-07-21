import java.util.Random;

public class test {

    String resToString(int[] numbers) {
        String out = "";
        for (int n : numbers
        ) {
            out += String.valueOf(n) + " ";
        }
        return out;
    }

    int[] randomize(){
        int length = 6;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = new Random().nextInt(49);
        }
        return result;
    }

    public static void main(String[] args) {
        test a = new test();

        System.out.println(a.resToString(new int[]{1,23,4,5}));
        System.out.println(a.resToString(a.randomize()));

    }
}