package JDBC;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class App {
    private static Properties connectionProp;
    private static Connection myConnection;
    private static Statement statement;

    public static void main(String[] args) throws IOException, SQLException {
        loadProperties();
        setupConnection();
        shootQuery();

    }
    public static void shootQuery() throws SQLException {

        statement.execute("CREATE table");
        statement.close();
        myConnection.close();
    }



    public static void setupConnection() throws SQLException {
        myConnection = DriverManager.getConnection(connectionProp.getProperty("url"), connectionProp);
        statement = myConnection.createStatement();
    }

    public static void loadProperties() throws IOException {
        FileInputStream inputStr = new FileInputStream("C:\\Users\\m1rage\\IdeaProjects\\Simple Demos\\JDBCDemo\\connectionINFO.properties");
        connectionProp = new Properties();
        connectionProp.load(inputStr);
        inputStr.close();
    }
}
