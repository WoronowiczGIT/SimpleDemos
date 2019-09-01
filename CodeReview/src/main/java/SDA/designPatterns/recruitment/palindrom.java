package SDA.designPatterns.recruitment;

import java.util.*;

public class palindrom {

    // wielkosc liter ma znaczenie
    // brak nulla
    // empty to palimdrom
    // znaki białe uwzgledniamy
    // utf-8
    // na wyjsciu boolean
    // jak ma nazywać sie funkcja?

    public static boolean isPalimdrom(String input) {
        // forward is always less then backward -> unnecessary
        if (input.isEmpty()) {
            return true;
        }

        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalimdrom2(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString().equals(input);
    }

    public static Character findFirstRepeatedChar(String input) {
        char[] characters = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {

            char currentChar = input.charAt(i);
            for (int j = 0; j < i; j++) {
                if (characters[j] == currentChar) {
                    return currentChar;
                }
            }
            characters[i] = currentChar;
        }
        return (char) 0;
    }

    public static Character findFirstRepeatedChar2(String input) {
        Set<Character> values = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            Character myChar = input.charAt(i);
            if (values.contains(myChar)) {
                return input.charAt(i);
            } else {
                values.add(myChar);
            }
        }
        return (char) 0;
    }

    //najbliższa = +/-1
    //format zwracany
    public static String findPairClosestTo(int[] input1, int[] input2, int sum) {
        String result = "";
        for (int i = 0; i < input1.length; i++) {
            for (int j = 0; j < input2.length; j++) {
                int currentSum = input1[i] + input2[j];
                if (currentSum > sum - 2 && currentSum < sum + 2) {
                    result += "[" + input1[i] + "," + input2[j] + "]";
                }
            }
        }
        return result;
    }

    public static String findPairClosestTo2(int[] input1, int[] input2, int sum) {
        Arrays.sort(input1);
        Arrays.sort(input2);
        String result = "";
        for (int i = 0; i < input1.length; i++) {
            for (int j = input2.length - 1; j >= 0; j--) {
                if (isClose(input1[i], input2[j], sum)) {
                    result += "[" + input1[i] + "," + input2[j] + "]";
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isClose(int first, int second, int sum) {
        int currentSum = first + second;
        if (currentSum > sum - 2 && currentSum < sum + 2) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        int[] in1 = {-1, 3, 8, 2, 9, 5};
        int[] in2 = {4, 1, 2, 10, 5, 20};
        Arrays.sort(in1);
        System.out.println(Arrays.toString(in1));
        int sum = 24;
        System.out.println(findPairClosestTo(in1, in2, sum));
        System.out.println("---- cross word ----");
        System.out.println(findPairClosestTo2(in1, in2, sum));


    }
}
