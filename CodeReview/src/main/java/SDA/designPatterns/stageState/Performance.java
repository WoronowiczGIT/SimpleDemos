package SDA.designPatterns.stageState;

public class Performance {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.play();
        stage.change();
        stage.play();
    }
}

class Actor{
    public void act(){}
}

class HappyActor extends Actor{
    public void act(){
        System.out.println("be happy");
    }
}
class SadActor extends Actor{
    public void act(){
        System.out.println("be sad");
    }
}
class Stage{
    Actor a = new HappyActor();
    public void change(){
        a = new SadActor();
    }
    public void play(){
        a.act();
    }
}
