package tictactoe.board;

public class BoardFactory {

    private final CellFactory cellFactory;

    public BoardFactory() {
        this.cellFactory = new CellFactory();
    }

    public Board createBoard(int dimension) {
        return new Board(dimension, cellFactory);
    }
}
