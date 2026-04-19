package tictactoe.strategy;

import tictactoe.board.Board;

public interface IWinStrategy {
    boolean checkWin(Board board);
}
