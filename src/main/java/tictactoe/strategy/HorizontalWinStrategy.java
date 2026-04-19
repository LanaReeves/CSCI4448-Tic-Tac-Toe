package tictactoe.strategy;

import tictactoe.board.Board;

public class HorizontalWinStrategy extends BaseWinStrategy {

    @Override
    public boolean checkWin(Board board) {
        return horizontalWin(board);
    }
}
