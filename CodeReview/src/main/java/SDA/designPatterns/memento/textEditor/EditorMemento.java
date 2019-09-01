package SDA.designPatterns.memento.textEditor;

public class EditorMemento {

    private final FontColor color;

    private final String content;

    private final int fontSize;

    public EditorMemento(Editor editor){
        color = editor.getColor();
        content = editor.getContent();
        fontSize = editor.getFontSize();
    }

    public FontColor getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }

    public int getFontSize() {
        return fontSize;
    }
}
