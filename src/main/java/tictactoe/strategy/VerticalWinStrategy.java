package tictactoe.strategy;

import tictactoe.board.Board;

public class VerticalWinStrategy extends StandardWinStrategy {

    @Override
    public boolean checkWin(Board board) {
        return verticalWin(board);
    }


}
