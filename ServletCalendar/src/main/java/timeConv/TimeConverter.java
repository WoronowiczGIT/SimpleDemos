package timeConv;

import java.util.ArrayDeque;
import java.util.Queue;

public class TimeConverter {

    public String convert(long duration) {
        StringBuilder sb = new StringBuilder();
        long rest;

        Queue<String> timeUnits = new ArrayDeque<>();
        timeUnits.add("s");
        timeUnits.add("m");
//        timeUnits.add("h");

        while (duration > 0){

            if(!timeUnits.isEmpty()){
                rest = duration % 60;
                sb.insert(0, rest + timeUnits.poll());
                duration /= 60L;
            }
            if(duration > 0 && timeUnits.isEmpty()){
                sb.insert(0,duration+"h");
                duration = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TimeConverter tc = new TimeConverter();

        System.out.println(tc.convert(3600075));
        System.out.println(tc.convert(1));
        System.out.println(tc.convert(75));
        System.out.println(tc.convert(375));
    }
}


