package SDA.designPatterns.memento.article;

public class Test {
    public static void main(String[] args) {
        Article article = new Article("title","author","some content");
        ArticleMemento memento = new ArticleMemento();
        article.printArticle();
        article.setTitle("new title");
        article.printArticle();
        memento.save(article);
        article.setTitle("super new title");
        memento.save(article);
        article.printArticle();
        article.setTitle("best possible title");
        memento.save(article);
        article.printArticle();


        memento.revert(article);
        article.printArticle();

        memento.revert(article);
        article.printArticle();

        memento.revert(article);
        article.printArticle();
    }
}
