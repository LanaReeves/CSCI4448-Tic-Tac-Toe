package tictactoe.board;

import tictactoe.Marker;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell[]> board = new ArrayList<>();
    private final int dimension;
    private final CellFactory cellFactory;

    public Board(int dimension, CellFactory cellFactory) {
        this.dimension = dimension;
        this.cellFactory = cellFactory;
        createBoard();
    }

    private void createBoard() {
        for(int row = 0; row < dimension; row++) {
            Cell[] rowCells = new Cell[dimension];
            for(int col = 0; col < dimension; col++) {
               rowCells[col] = cellFactory.createCell(row,col);
            }
            board.add(rowCells);
        }
    }

    public List<Cell[]> getBoard() {
        return board;
    }

    public void updateCell(Cell cell, Marker playerMarker) {
        cell.setMarker(playerMarker);
    }

    public List<Cell> getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<>();
        for(Cell[] row: board) {
            for(int i = 0; i < dimension; i++) {
                Marker marker = row[i].getMarker();
                if(marker == null) {
                    emptyCells.add(row[i]);
                }
            }
        }
        return emptyCells;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for(Cell[] row: board) {
            for(int i = 0; i < dimension; i++) {
                Marker marker = row[i].getMarker();
                if(marker == null) {
                    boardString.append("-");
                }
                else {
                    boardString.append(marker);
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
