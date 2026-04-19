package tictactoe.strategy;

import tictactoe.board.Board;

public class DiagonalWinStrategy extends BaseWinStrategy {

    @Override
    public boolean checkWin(Board board) {
        return diagonalWin(board);
    }
}
