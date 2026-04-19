package tictactoe.commands;

import tictactoe.Marker;
import tictactoe.board.Board;
import tictactoe.board.Cell;
import tictactoe.player.Player;

public class MoveCommand implements ICommand{
    private final Board board;
    private final Cell cell;
    private final Marker marker;
    private final Player currentPlayer;

    public MoveCommand (Board board, Cell cell, Player currentPlayer) {
        this.board = board;
        this.cell = cell;
        this.marker = currentPlayer.getMarker();
        this.currentPlayer = currentPlayer;
    }


    @Override
    public boolean execute() {
        return board.updateCell(cell, marker);
    }
    @Override
    public void undo() {
        cell.setMarker(null);
    }

    public Player getPlayer() {
        return currentPlayer;
    }
}
