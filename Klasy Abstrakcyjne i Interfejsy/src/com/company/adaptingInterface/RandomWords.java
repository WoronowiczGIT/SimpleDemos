package com.company.adaptingInterface;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {
    private Random r = new Random(1);
    private final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUWXYZ".toCharArray();
    private final char[] lowerCase = "ABCDEFGHIJKLMNOPQRSTUWXYZ".toLowerCase().toCharArray();
    private final char[] vowels = "aeiouy".toCharArray();

    private int length;
    private int count;

    public RandomWords(int count, int length) {
        this.count = count;
        this.length = length;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;

        cb.append(capitals[r.nextInt(capitals.length)]);
        for (int i = 1; i < length; i += 2) {
            cb.append(lowerCase[r.nextInt(lowerCase.length)]);
            cb.append(vowels[r.nextInt(vowels.length)]);
        }
        cb.append(" ");

        return length;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(4, 14));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}