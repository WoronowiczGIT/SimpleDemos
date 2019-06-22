package JDBC;

import java.time.LocalDate;

public class Post {
    private int id;
    private String content;
    private int userID;
    private LocalDate date;

    public Post(int id, String content, int userID, LocalDate date) {
        this.id = id;
        this.content = content;
        this.userID = userID;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
