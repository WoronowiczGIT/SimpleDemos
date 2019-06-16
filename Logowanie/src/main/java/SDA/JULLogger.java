package SDA;

import java.io.IOException;
import java.util.logging.*;

public class JULLogger {
    protected static final Logger logger = Logger.getLogger(JULLogger.class.getName());

    public static void defaultLoggingDemo(){
        // by default send log to System.err
        logger.log(Level.INFO,"place holder text");
    }

    public static void loggingLevelsDemo(){
        logger.info("logging on info lvl");
        logger.log(Level.INFO,"also logging on info lvl");
        logger.setLevel(Level.WARNING);
        logger.warning("logging on warning level");
        logger.info("logging below warning level");
    }

    public static void priorityLevelDemo(){
        // Hierarchy of logging: SEVERE (highest)->WARNING->INFO->CONFIG->FINE->FINER->FINEST
        logger.setLevel(Level.CONFIG);
        logger.log(Level.INFO,"higher priority");
        // When priority is lower then a set value, it wont log.
        logger.log(Level.FINE,"lower priority");
    }

    public static void handlerDemo() throws IOException {
    //The handler receives the log message from the logger and exports it to a certain target.
    //Each logger can have multiple handler.
        logger.addHandler(new ConsoleHandler());
        logger.log(Level.INFO,"send logs to console");

        //A handler can be turned off with the setLevel(Level.OFF) method and turned on with setLevel() method.
        logger.setLevel(Level.OFF);
        logger.log(Level.SEVERE,"no handler, equals no logging, no mather the Level");
    }

    public static void handlerDemo2(){
        logger.setLevel(Level.FINEST);
        Handler finest = new ConsoleHandler();
        finest.setLevel(Level.FINEST);
        logger.addHandler(finest);
        logger.log(Level.FINEST,"this msg is only logged by finest handler");
        logger.log(Level.INFO,"this msg is logged by finest and default handler");
    }

    public static void handlerDemo3() throws IOException {
        Handler fileHandler = new FileHandler("util.log");
        logger.addHandler(fileHandler);
        logger.log(Level.INFO,"send warning to util.log file");

        //change formatting from fxml to self defined
        fileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return "<<<>>> "
                        +record.getLoggerName()
                        +" "
                        +record.getMessage()
                        +" "
                        +record.getMillis()
                        +" <<<>>>";
            }
        });
        logger.log(Level.INFO,"send warning to util.log file, but in new format");
        logger.setLevel(Level.WARNING);
        logger.log(Level.INFO,"if you change logging level, it wont log");
    }

    public static void main(String[] args) throws IOException {
        handlerDemo3();
    }


}
