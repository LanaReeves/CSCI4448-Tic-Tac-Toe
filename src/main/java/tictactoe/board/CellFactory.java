package tictactoe.board;

public class CellFactory {

    public Cell createCell(int x, int y) {
        return new Cell(x,y);
    }

}
