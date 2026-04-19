package tictactoe.board;

import tictactoe.Marker;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Cell[][] board;
    private final int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        createBoard();
    }

    private void createBoard() {
        board = new Cell[dimension][dimension];
        for(int row = 0; row < dimension; row++) {
            for(int col = 0; col < dimension; col++) {
               board[row][col] = Board.newCell(row, col);
            }
        }
    }

    private static Cell newCell(int row, int col) {
        return new Cell(row, col);

    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getDimension() {
        return dimension;
    }

    public boolean updateCell(Cell cell, Marker playerMarker) {
        if (cell.getMarker() == null) {
            cell.setMarker(playerMarker);
            return true;
        }

        return false;
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

    public boolean isFull() {
        for (Cell[] row: board) {
            for(int i = 0; i < dimension; i++) {
                if (row[i].getMarker() == null){
                    return false;
                }
            }
        }
        return true;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }


    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("  ");
        for(int i = 0; i < dimension; i++) {
            boardString.append(i+1).append(" ");
        }

        boardString.append("\n");

        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                if (j == 0) {
                    boardString.append(i+1).append(" ");
                }
                Marker marker = board[i][j].getMarker();
                if(marker == null) {
                    boardString.append("- ");
                }
                else {
                    boardString.append(marker).append(" ");
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
