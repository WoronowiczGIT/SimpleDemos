package SDA.designPatterns.memento.textEditor;

import java.util.Stack;

public class Editor {

    private FontColor color;

    private int fontSize;

    private String content;

    private Stack<EditorMemento> mementos = new Stack<>();

    public Editor(FontColor color, int fontSize, String content) {
        this.color = color;
        this.fontSize = fontSize;
        this.content = content;
    }

    public void save() {
        mementos.add(new EditorMemento(this));
    }

    public void load() {
        EditorMemento memento = mementos.pop();
        this.color = memento.getColor();
        this.content = memento.getContent();
        this.fontSize = memento.getFontSize();
    }

    public FontColor getColor() {
        return color;
    }

    public void setColor(FontColor color) {
        this.color = color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
