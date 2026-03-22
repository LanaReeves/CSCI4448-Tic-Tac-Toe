package tictactoe.player;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, Marker marker) {
        super(name, marker);
    }

    @Override
    public Cell move(Board board) {
        return null;
    }

}
