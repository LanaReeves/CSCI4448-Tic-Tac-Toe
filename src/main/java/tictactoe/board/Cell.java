package tictactoe.board;

import tictactoe.Marker;

public class Cell {
    private final int x;
    private final int y;
    private Marker marker = null;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Marker getMarker() {
        return marker;
    }
}
