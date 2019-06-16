package JDBC;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Demo {
    private static ResultSet resultSet;
    private static Connection myConnection;
    private static Statement statement;
    private static Properties connectionProp;
    final static String DB_URL = "jdbc:mysql://localhost:3306/users";

    public static void main(String[] args) throws SQLException {

        connect();
        updateUser();
//        updateUser();
//        insertUser();
//        removeUser();
//        mapUser();
//        antiSQLInjection();
//        SQLinjection();
//        update();
//        insert();
//        select();

    }
    public static void filterUsers() throws SQLException {
        String columnName = "uname";
        String columnValue = "password";
        PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM users WHERE ?=?");
        pstmt.setString(1,columnName);
        pstmt.setString(2,columnValue);

        List<User>
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){

        }
    }

    public static void updateUser() throws SQLException {
        String from = "name4";
        String to = "name444";
        PreparedStatement pstmt = myConnection.prepareStatement("UPDATE users set uname=? WHERE uname=?");
        pstmt.setString(1,to);
        pstmt.setString(2,from);
        pstmt.execute();
        // zamykamy tylko to czego uzywamy
        pstmt.close();
        myConnection.close();
    }

    public static void insertUser() throws SQLException {
        User user = new User("superUniqe","InsertPassword");
        PreparedStatement pstmt = myConnection.prepareStatement("INSERT INTO users (uname,password) VALUES (?,?)");
        pstmt.setString(1,user.getName());
        pstmt.setString(2,user.getPassword());
        pstmt.execute();
        // zamykamy tylko to czego uzywamy
        pstmt.close();
        myConnection.close();
    }

    public static void removeUser() throws SQLException {
        String name = "name2";
        PreparedStatement pStatement = myConnection.prepareStatement("DELETE FROM users where uname = ?");
        pStatement.setString(1,name);
        pStatement.execute();
    }

    public static void mapUser() throws SQLException {
        String name = "name2";
        PreparedStatement pStatement = myConnection.prepareStatement("Select uname, password from users where uname = ?");
        pStatement.setString(1,name);
        resultSet = pStatement.executeQuery();
        while (resultSet.next()) {
            String uname = resultSet.getString("uname");
            String password = resultSet.getString("password");
            User user = new User(uname,password);
            System.out.println(user.getName()+" "+user.getPassword());
        }

    }


    public static void antiSQLInjection() throws SQLException {
        String goodName = "name2";
        String badName = "' or true or '";
        String name = goodName;
        PreparedStatement pStatement = myConnection.prepareStatement("Select uname from users where uname = ?");
        pStatement.setString(1,name);
        resultSet = pStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("uName"));
        }
    }

    public static void SQLinjection() throws SQLException {
        String goodName = "name2";
        String badName = "' or true or '";
        String name = badName;
        String query = "select uname from users where uname = '" + name + "'";
        statement.execute(query);
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("uName"));
        }
    }


    public static void update() throws SQLException {
        String sql = "update users set uname = 'unameXXX' where uname = 'XXX';";
        statement.execute(sql);
    }

    public static void insert() throws SQLException {
        String sql = "Insert into users(uname,password) values ('javaImie', 'JavaHaslo')";
        statement.executeUpdate(sql);
        close();
    }

    public static void select() throws SQLException {
        String sql = "SELECT uname, id FROM users;";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("uName"));
            System.out.println(resultSet.getString("id"));
        }
    }


    public static void connect() throws SQLException {
        connectionProp = new Properties();
        connectionProp.put("user", "root");
        connectionProp.put("password", "ShutUp4ndSQL");
        connectionProp.put("serverTimezone", "CET");
        myConnection = DriverManager.getConnection(DB_URL, connectionProp);
        statement = myConnection.createStatement();
    }

    public static void close() throws SQLException {
        resultSet.close();
        myConnection.close();
    }
}