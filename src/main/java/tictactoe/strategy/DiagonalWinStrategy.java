package tictactoe.strategy;

import tictactoe.board.Board;

public class DiagonalWinStrategy extends StandardWinStrategy {

    @Override
    public boolean checkWin(Board board) {
        return diagonalWin(board);
    }
}
