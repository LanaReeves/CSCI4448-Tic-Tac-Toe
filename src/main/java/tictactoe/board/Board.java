package tictactoe.board;

import tictactoe.Marker;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell[]> board = new ArrayList<>();
    private final int dimension;
    private Marker markerWon;

    public Board(int dimension) {
        this.dimension = dimension;
        createBoard();
    }

    private void createBoard() {
        for(int row = 0; row < dimension; row++) {
            Cell[] rowCells = new Cell[dimension];
            for(int col = 0; col < dimension; col++) {
               rowCells[col] = Board.newCell(row, col);
            }
            board.add(rowCells);
        }
    }

    private static Cell newCell(int row, int col) {
        return new Cell(row, col);

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

    public boolean horizontalWin(){
        for (Cell[] row : board) {
            Marker marker = row[0].getMarker();
            if (marker != null) {
                boolean win = true;
                for(int col = 1; col < dimension; col++) {
                    if (row[col].getMarker() != marker) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    markerWon = marker;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalWin() {
        for (int col = 0; col < dimension; col++) {
            Marker marker = board.getFirst()[col].getMarker();

            if (marker != null) {
                boolean win = true;
                for (int row = 1; row < dimension; row++) {
                    if (board.get(row)[col].getMarker() != marker) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    markerWon = marker;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagonalWin() {
        return (diagonalWinFirst() || diagonalWinSecond());
    }


    private boolean diagonalWinFirst() {
        boolean win = true;
        Marker marker = board.getFirst()[0].getMarker();
        if (marker != null) {
            for (int i = 1; i < dimension; i++) {
                if (board.get(i)[i].getMarker() != marker) {
                    win = false;
                    break;
                }
            }
            if (win) {
                markerWon = marker;
            }
            return win;
        }
        return false;
    }

    private boolean diagonalWinSecond() {
        boolean win = true;
        Marker marker = board.getFirst()[dimension - 1].getMarker();

        if (marker != null) {
            for (int i = 1; i < dimension; i++) {
                if (board.get(i)[dimension - 1 - i].getMarker() != marker) {
                    win = false;
                    break;
                }
            }
            if (win) {
                markerWon = marker;
            }
            return win;
        }
        return false;
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
        return board.get(row)[col];
    }

    public Marker getMarkerWon() {return markerWon;}

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
                Marker marker = board.get(i)[j].getMarker();
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
