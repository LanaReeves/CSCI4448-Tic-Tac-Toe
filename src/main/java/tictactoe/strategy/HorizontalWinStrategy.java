package tictactoe.strategy;

import tictactoe.board.Board;

public class HorizontalWinStrategy extends StandardWinStrategy {

    @Override
    public boolean checkWin(Board board) {
        return horizontalWin(board);
    }
}
