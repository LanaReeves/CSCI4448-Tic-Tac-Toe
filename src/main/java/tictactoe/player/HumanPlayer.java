package tictactoe.player;

import org.slf4j.Logger;
import tictactoe.Marker;
import tictactoe.TicTacToe;
import tictactoe.board.Board;
import tictactoe.board.Cell;

public class HumanPlayer extends Player{
    static Logger logger = org.slf4j.LoggerFactory.getLogger(TicTacToe.class);

    public HumanPlayer(Marker marker) {
        super(marker);
    }

    @Override
    public boolean isHuman() {
        return true;
    }

    @Override
    public Cell move(Board board) {
        logger.info("Human player requires row and column to move");
        return null;
    }

}
