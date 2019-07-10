package com.company.adaptingInterface;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomIntegers {
    private static Random r = new Random();
    public int next(){
        return r.nextInt(100);
    }
}

class AdapterRandomInt extends RandomIntegers implements Readable{
    private int count;

    AdapterRandomInt(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0) return -1;
        // cb need a space at the end of string
        String out = next()+" ";
        cb.append(out);
        return out.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdapterRandomInt(8));
        while (s.hasNext()){
            System.out.println(s.next());
        }
    }
}