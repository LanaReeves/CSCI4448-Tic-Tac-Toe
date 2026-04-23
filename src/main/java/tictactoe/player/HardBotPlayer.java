package tictactoe.player;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;
import tictactoe.strategy.IWinStrategy;

import java.util.List;
import java.util.Random;


public class HardBotPlayer extends Player {
    private IWinStrategy winningStrategy;
    private static final Random rand = new Random();


    public HardBotPlayer(String name, Marker marker, IWinStrategy strategy) {
        super(marker);
        this.name = name;
        this.winningStrategy = strategy;
    }


    public HardBotPlayer(String name, Marker marker) {
        super(marker);
        this.name = name;
    }

    @Override
    public Cell move(Board board) {
        Cell cellChoice;

        cellChoice = tryToWin(board, this.getMarker());
        if (cellChoice != null) {
            return cellChoice;
        }

        cellChoice = blockOpponentWin(board);
        if (cellChoice != null) {
            return cellChoice;
        }

        cellChoice = takeCenter(board);
        if (cellChoice != null) {
            return cellChoice;
        }

        cellChoice = takeCorner(board);
        if (cellChoice != null) {
            return cellChoice;
        }

        List<Cell> emptyCells = board.getEmptyCells();
        return emptyCells.get(rand.nextInt(emptyCells.size()));
    }

    private Cell tryToWin(Board board, Marker marker) {
        for (Cell cell: board.getEmptyCells()) {
            cell.setMarker(marker);

            if (winningStrategy.checkWin(board)) {
                cell.setMarker(null);
                return cell;
            }
            cell.setMarker(null);
        }
        return null;
    }

    private Cell blockOpponentWin(Board board) {
        Marker opponentMarker;
        if (this.getMarker() == Marker.O) {
            opponentMarker = Marker.X;
        }
        else {
            opponentMarker = Marker.O;
        }
        return tryToWin(board, opponentMarker);
    }

    private Cell takeCenter(Board board) {
        int centerValue = board.getDimension() / 2;

        Cell centerCell = board.getCell(centerValue, centerValue);

        if (centerCell.getMarker() == null) {
            return centerCell;
        }
        return null;
    }

    private Cell takeCorner(Board board) {
        int lastValueOnBoard = board.getDimension()-1;
        Cell[] cornerValues = {board.getCell(0,0), board.getCell(0, lastValueOnBoard), board.getCell(lastValueOnBoard, 0), board.getCell(lastValueOnBoard, lastValueOnBoard)};

        for (Cell cornerCell: cornerValues) {
            if(cornerCell.getMarker() == null) {
                return cornerCell;
            }
        }

        return null;
    }

    public void updateStrategy(IWinStrategy winStrategy) {
        this.winningStrategy = winStrategy;
    }

    @Override
    public boolean isHardBot() {
        return true;
    }
}
