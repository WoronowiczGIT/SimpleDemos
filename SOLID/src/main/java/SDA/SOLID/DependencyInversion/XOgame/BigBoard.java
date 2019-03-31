package SDA.SOLID.DependencyInversion.XOgame;

public class BigBoard implements Board {
    private int[] board;

    public BigBoard(int[] board) {
        this.board = board;
    }

    @Override
    public Boolean checkField(int field) {
        if(board[field]>5)return true;
        return false;
    }
}
