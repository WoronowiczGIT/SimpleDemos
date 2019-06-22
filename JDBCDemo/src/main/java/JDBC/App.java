package JDBC;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class App {
    private static Properties connectionProp;
    private static Connection myConnection;
    private static Statement statement;

    public static void main(String[] args) throws IOException, SQLException {
        loadProperties();
        setupConnection();
        filterBy3(LocalDate.now(),null,null);
//        shootQuery();
//        selectWithPassword("HashedPassword");
    }
    public static void selectWithPassword(String pass) throws SQLException {
        PreparedStatement statement = myConnection.prepareStatement("select * from users where password= MD5(?)");
        statement.setString(1,pass);
        statement.executeQuery();
        ResultSet rs = statement.getResultSet();
        while(rs.next()){
            System.out.println(rs.getString("uname")+" "+rs.getString("password"));
        }
    }
    public static void filterBy3(LocalDate date,Integer idUser,Integer idPost) throws SQLException {
        StringBuilder query = new StringBuilder("select * from posts where ");


        if(date != null){
            query.append(" DATE_FORMAT(?, \"%Y\")= DATE_FORMAT(\"2019-06-22\", \"%Y\")");

        }
        if(idUser != null){
            query.append(" AND user_id = ?");

        }
        if(idPost != null){
            query.append(" AND id = ?");

        }
        PreparedStatement statement = myConnection.prepareStatement(query.toString());
        int index = 1;
        if(date != null){
            statement.setString(index++,String.valueOf(date));
        }
        if(idUser != null){
            statement.setInt(index++,idUser);
        }
        if(idPost != null){
            statement.setInt(index++,idPost);
        }

        statement.executeQuery();
        ResultSet rs = statement.getResultSet();
        while(rs.next()){
            System.out.println(rs.getString("content")+" "+rs.getString("postDate"));
        }
    }

    public static void shootQuery() throws SQLException {

        statement.execute("Select * from users");

        ResultSet rs = statement.getResultSet();
        while(rs.next()){
            System.out.println(rs.getString("uname")+" "+rs.getString("password"));
        }

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
