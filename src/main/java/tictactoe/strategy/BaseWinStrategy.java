package tictactoe.strategy;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;

public class BaseWinStrategy implements IWinStrategy {

    public boolean checkWin(Board board) {
        return diagonalWin(board) || horizontalWin(board) || verticalWin(board);

    }

    public boolean diagonalWin(Board board) {
        return (diagonalWinFirst(board) || diagonalWinSecond(board));
    }


    private boolean diagonalWinFirst(Board board) {
        boolean win = true;
        Marker marker = board.getBoard()[0][0].getMarker();
        if (marker != null) {
            for (int i = 1; i < board.getDimension(); i++) {
                if (board.getBoard()[i][i].getMarker() != marker) {
                    win = false;
                    break;
                }
            }
            return win;
        }
        return false;
    }

    private boolean diagonalWinSecond(Board board) {
        boolean win = true;
        Marker marker = board.getBoard()[0][board.getDimension() - 1].getMarker();

        if (marker != null) {
            for (int i = 1; i < board.getDimension(); i++) {
                if (board.getBoard()[i][board.getDimension() - 1 - i].getMarker() != marker) {
                    win = false;
                    break;
                }
            }
            return win;
        }

        return false;
    }

    public boolean horizontalWin(Board board){
        for (Cell[] row : board.getBoard()) {
            Marker marker = row[0].getMarker();
            if (marker != null) {
                boolean win = true;
                for(int col = 1; col < board.getDimension(); col++) {
                    if (row[col].getMarker() != marker) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalWin(Board board) {
        for (int col = 0; col < board.getDimension(); col++) {
            Marker marker = board.getBoard()[0][col].getMarker();

            if (marker != null) {
                boolean win = true;
                for (int row = 1; row < board.getDimension(); row++) {
                    if (board.getBoard()[row][col].getMarker() != marker) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
}
