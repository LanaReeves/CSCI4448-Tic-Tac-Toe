package tictactoe.player;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private final Scanner scanner;

    public HumanPlayer(Marker marker, Scanner scanner) {
        super(marker);
        this.scanner = scanner;
    }

    @Override
    public Cell move(Board board) {
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        return board.getCell(row-1, col-1);
    }

    @Override
    public boolean isHuman() {
        return true;
    }

}
