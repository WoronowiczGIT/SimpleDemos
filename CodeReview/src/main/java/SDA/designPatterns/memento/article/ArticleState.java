package SDA.designPatterns.memento.article;

public class ArticleState {

    private final String Title;

    private final String Author;

    private final String Content;

    public ArticleState(String title, String author, String content) {
        Title = title;
        Author = author;
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getContent() {
        return Content;
    }
}
