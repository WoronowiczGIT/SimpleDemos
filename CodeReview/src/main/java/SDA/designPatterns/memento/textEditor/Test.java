package SDA.designPatterns.memento.textEditor;

public class Test {
    public static void main(String[] args) {
        Editor editor = new Editor(FontColor.BLACK,25,"some content");
        System.out.println(editor.getColor());
        editor.setColor(FontColor.RED);
        System.out.println(editor.getColor());
        editor.save();
        editor.setColor(FontColor.BLUE);
        System.out.println(editor.getColor());
        editor.load();
        System.out.println(editor.getColor());

    }
}
