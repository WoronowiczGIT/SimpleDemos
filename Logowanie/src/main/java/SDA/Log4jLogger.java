package SDA;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import java.io.IOException;

public class Log4jLogger {
    //protected static final Logger logJU = Logger.getLogger(Log4jLogger.class.getName());
    // trzeba dorzucic log4j main->resources-> add log4j.properties
    // w properties layout
    // ewentualnie dorzućić zależność do pom.xml

//     <resources>
//        <resource>
//            <directory>src/main/resources</directory>
//            <excludes>
//                <exclude>**/*.java</exclude>
//            </excludes>
//        </resource>
//    </resources>

    protected static final org.apache.log4j.Logger log4j =
            org.apache.log4j.Logger.getLogger(Log4jLogger.class.getName());


    public static void main(String[] args) throws IOException {

    defaultLog("log1");
    }

    public static void defaultLog(String msg){
        log4j.info(msg);
    }
    public static void loggingLevels(String msg){
        //if set level is higher then you want to log, it wont log
        log4j.setLevel(Level.FATAL);
        log4j.info(msg);
    }
    public static void disableAppendingLogFile() throws IOException {
        log4j.addAppender(new FileAppender(new PatternLayout(),"log4j.log", false));
    }

}
