package SDA.designPatterns.memento.article;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArticleMemento {

    private Deque<ArticleState> states = new ArrayDeque<>();

    public void save(Article article){
        ArticleState state = new ArticleState(article.getTitle(),article.getContent(),article.getAuthor());
        states.add(state);
    }
    public void revert(Article article){
        ArticleState state = states.pollLast();
        article.setAuthor(state.getAuthor());
        article.setContent(state.getContent());
        article.setTitle(state.getTitle());
        System.out.println("--Reverting changes--");
    }

}
