package SDA.SOLID.DependencyInversion.XOgame;

public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

  public  void tryField(int n){
        if(board.checkField(n)){
            System.out.println("trafiony");
        }else System.out.println("chybiony");
    }
}
