package SDA;

import org.apache.log4j.Logger;

public class Logowanie {
    //protected static final Logger logJU = Logger.getLogger(Logowanie.class.getName());
    // trzeba dorzucic log4j main->resources-> add log4j.properties
    // w properties layout
    protected static final org.apache.log4j.Logger logger4j =
            org.apache.log4j.Logger.getLogger(Logowanie.class.getName());


    protected  void RNG() {
        int a,i = 0;
        while (i < 10) {

        a=(int)(Math.random()*100);
        logger4j.fatal("wylosowano liczbe: "+ a);
            System.out.println(a);
        i++;
        }
    }

}
