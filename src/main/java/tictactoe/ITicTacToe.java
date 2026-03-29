package tictactoe;

import tictactoe.board.Board;
import tictactoe.player.Player;

public interface ITicTacToe {
    void playTurn();
    boolean isOver();

    Board getBoard();

    boolean currentPlayerIsHuman();
    boolean player1IsHuman();
    boolean player2IsHuman();
    Player getWinningPlayer();

    void enterPlayer1Name(String name);
    void enterPlayer2Name(String name);

}
