package tictactoe.player;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;

import java.util.List;
import java.util.Random;

public class BotPlayer extends Player {
    private static final Random rand = new Random();


    public BotPlayer(String name, Marker marker) {
        super(name, marker);
    }

    @Override
    public Cell move(Board board) {
        List<Cell> emptyCells = board.getEmptyCells();
        return emptyCells.get(rand.nextInt(emptyCells.size()));
    }

}
