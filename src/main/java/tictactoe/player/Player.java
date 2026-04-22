package tictactoe.player;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;

abstract public class Player {
    protected String name;
    private final Marker marker;

    public Player(Marker marker) {
        this.marker = marker;
    }

    public String getName() {
        return name;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract public Cell move(Board board);
    public Cell move(Board board, int row, int col) {
        return board.getCell(row-1, col-1);
    }


    public boolean isHuman() { return false; }
}
