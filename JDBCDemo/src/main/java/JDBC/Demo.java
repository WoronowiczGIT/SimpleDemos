package JDBC;

import java.sql.*;
import java.util.*;

public class Demo {
    private static ResultSet resultSet;
    private static Connection myConnection;
    private static Statement statement;
    private static Properties connectionProp;
    private static String DBname = "users";
    final static String DB_URL = "jdbc:mysql://localhost:3306/" + DBname ;

    public static void main(String[] args) throws SQLException {

        connect();
//        createTableV2(); <-wont work
//        insertHashedPassword();
//        createTable();
//        addColumn();
//        filterUsers();
//        updateUser();
//        updateUser();
//        insertUser();
//        removeUser();
//        mapUser();
//        antiSQLInjection();
//        SQLinjection();
//        update();
//        insert();
        select();

    }
    public static void insertHashedPassword() throws SQLException {
        String user ="newUser112";
        String pass ="HashedPassword";
        String sql = "insert into users values (default ,?,MD5(?))";
        PreparedStatement statement = myConnection.prepareStatement(sql);
        statement.setString(1,user);
        statement.setString(2,pass);
        statement.execute();
        statement.close();
        myConnection.close();
    }

    //CAN WE PARAMETRIZE CREATE TABLE?
    public static void createTable() throws SQLException {
        PreparedStatement statement = myConnection.prepareStatement("CREATE TABLE newTable (column1 int, column2 varchar(123))");
        statement.execute();
        statement.close();
        myConnection.close();
    }
    // WONT WORK, PREPARED STATEMENT IS ONLY COMPATIBLE WITH DML (insert, select).
    public static void createTableV2() throws SQLException {
        String tableName = "newTableName";
        String columnName = "id";
        String columnType = "int";
        PreparedStatement statement = myConnection.prepareStatement("CREATE TABLE ? (? ?)");
        statement.setString(1,tableName);
        statement.setString(2,columnName);
        statement.setString(3,columnType);
        statement.execute();
        statement.close();
        myConnection.close();
    }


    //SYNTAX ERROR,  WHY CANT USE PARAMETERS?
    public static void addColumn() throws SQLException {
        String tableName = "users";
        String column = "newColumn3";
        PreparedStatement statement = myConnection.prepareStatement("ALTER TABLE " + tableName + " ADD " + column + " VARCHAR(155)");

        statement.executeUpdate();

        statement.close();
        myConnection.close();
    }

    public static void filterUsers() throws SQLException {
        String columnName = "password";
        String columnValue = "pass";
        PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM users WHERE " + columnName + "=?");

        pstmt.setString(1, columnValue);

        List<User> users = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String uname = rs.getString("uname");
            String pass = rs.getString("password");
            users.add(new User(uname, pass));
        }

        for (User u : users) {
            System.out.println(u.getName() + " " + u.getPassword());
        }
    }

    public static void updateUser() throws SQLException {
        String from = "name4";
        String to = "name444";
        PreparedStatement pstmt = myConnection.prepareStatement("UPDATE users set uname=? WHERE uname=?");
        pstmt.setString(1, to);
        pstmt.setString(2, from);
        pstmt.execute();
        // zamykamy tylko to czego uzywamy
        pstmt.close();
        myConnection.close();
    }

    public static void insertUser() throws SQLException {
        User user = new User("superUniqe", "InsertPassword");
        PreparedStatement pstmt = myConnection.prepareStatement("INSERT INTO users (uname,password) VALUES (?,?)");
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());
        pstmt.execute();
        // zamykamy tylko to czego uzywamy
        pstmt.close();
        myConnection.close();
    }

    public static void removeUser() throws SQLException {
        String name = "name2";
        PreparedStatement pStatement = myConnection.prepareStatement("DELETE FROM users where uname = ?");
        pStatement.setString(1, name);
        pStatement.execute();
    }

    public static void mapUser() throws SQLException {
        String name = "name2";
        PreparedStatement pStatement = myConnection.prepareStatement("Select uname, password from users where uname = ?");
        pStatement.setString(1, name);
        resultSet = pStatement.executeQuery();
        while (resultSet.next()) {
            String uname = resultSet.getString("uname");
            String password = resultSet.getString("password");
            User user = new User(uname, password);
            System.out.println(user.getName() + " " + user.getPassword());
        }

    }


    public static void antiSQLInjection() throws SQLException {
        String goodName = "name2";
        String badName = "' or true or '";
        String name = goodName;
        PreparedStatement pStatement = myConnection.prepareStatement("Select uname from users where uname = ?");
        pStatement.setString(1, name);
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
        connectionProp.put("useSSL", "false");
        myConnection = DriverManager.getConnection(DB_URL, connectionProp);
        statement = myConnection.createStatement();
    }

    public static void close() throws SQLException {
        resultSet.close();
        myConnection.close();
    }
}