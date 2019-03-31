package SDA.SOLID.DependencyInversion.XOgame;

public class SmallBoard implements Board {
    int[] board;

    public SmallBoard(int[] board){
        this.board=board;
    }

    @Override
    public Boolean checkField(int field) {
        if(board[field]>0)return true;
        return false;
    }
}
