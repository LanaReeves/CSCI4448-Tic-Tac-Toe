package tictactoe;

import tictactoe.board.Board;
import tictactoe.player.Player;


public interface ITicTacToe {
    void pickMove();
    void pickMove(int row, int col);
    boolean isOver();
    boolean canUndo();

    Board getBoard();

    boolean currentPlayerIsHuman();
    boolean player1IsHuman();
    boolean player2IsHuman();
    Player getWinningPlayer();
    String getWinningPlayersName();

    void enterPlayer1Name(String name);
    void enterPlayer2Name(String name);
    void undoMove();
}
