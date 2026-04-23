package tictactoe.board;

import org.junit.jupiter.api.Test;
import tictactoe.Marker;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;
import static org.junit.jupiter.api.Assertions.*;
import static tictactoe.Marker.X;

public class BoardTest {

    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void boardCreation() {
        int dimension = 3;
        Board threeByThree = new Board(dimension);
        Cell[][] board = threeByThree.getBoard();

        assertEquals(dimension, board.length);

        for(Cell[] row: board) {
            assertEquals(dimension, row.length);
            for(int i = 0; i < dimension; i++) {
                Marker marker = row[i].getMarker();
                assertNull(marker);
            }
        }
        System.out.println(threeByThree);
    }

    @Test
    public void updateCellMarkerBot() {
        int dimension = 3;
        Board threeByThree = new Board(dimension);
        Player bot1 = playerFactory.createEasyBot("bot1", X);

        Cell cellSelected = bot1.move(threeByThree);
        threeByThree.updateCell(cellSelected, X);

        assertEquals(X, cellSelected.getMarker());
        System.out.println(threeByThree);
    }


    @Test
    public void testBoardFull() {
        int dimension = 2;
        Board board = new Board(dimension);

        board.updateCell(board.getCell(0,0), X);
        board.updateCell(board.getCell(1,1), X);
        board.updateCell(board.getCell(0,1), X);
        board.updateCell(board.getCell(1,0), X);

        assertTrue(board.isFull());
    }
}
