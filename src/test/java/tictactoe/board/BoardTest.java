package tictactoe.board;

import org.junit.jupiter.api.Test;
import tictactoe.Marker;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static tictactoe.Marker.O;
import static tictactoe.Marker.X;

public class BoardTest {

    BoardFactory boardFactory = new BoardFactory();
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void boardCreation() {
        int dimension = 3;
        Board threeByThree = boardFactory.createBoard(dimension);
        List<Cell[]> board = threeByThree.getBoard();

        assertEquals(dimension, board.size());

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
        Board threeByThree = boardFactory.createBoard(dimension);
        Player bot1 = playerFactory.createBot("bot1", X);

        Cell cellSelected = bot1.move(threeByThree);
        threeByThree.updateCell(cellSelected, X);

        assertEquals(X, cellSelected.getMarker());
        System.out.println(threeByThree);
    }

    @Test
    public void testHorizontalWin() {
        int dimension = 3;
        Board threeByThree = boardFactory.createBoard(dimension);
        threeByThree.updateCell(threeByThree.getCell(0,0), X);
        threeByThree.updateCell(threeByThree.getCell(0,1), X);
        threeByThree.updateCell(threeByThree.getCell(0,2), X);

        assertTrue(threeByThree.horizontalWin());
        assertEquals(X, threeByThree.getMarkerWon());
        System.out.println(threeByThree);
    }

    @Test
    public void testVerticalWin() {
        int dimension = 3;
        Board threeByThree = boardFactory.createBoard(dimension);
        threeByThree.updateCell(threeByThree.getCell(0,2), O);
        threeByThree.updateCell(threeByThree.getCell(1,2), O);
        threeByThree.updateCell(threeByThree.getCell(2,2), O);

        assertTrue(threeByThree.verticalWin());
        assertEquals(O, threeByThree.getMarkerWon());
        System.out.println(threeByThree);
    }

    @Test
    public void testFirstDiagonalWin() {
        int dimension = 3;
        Board threeByThree = boardFactory.createBoard(dimension);
        threeByThree.updateCell(threeByThree.getCell(0,0), O);
        threeByThree.updateCell(threeByThree.getCell(1,1), O);
        threeByThree.updateCell(threeByThree.getCell(2,2), O);

        assertTrue(threeByThree.diagonalWin());
        assertEquals(O, threeByThree.getMarkerWon());
        System.out.println(threeByThree);
    }

    @Test
    public void testSecondDiagonalWin() {
        int dimension = 3;
        Board threeByThree = boardFactory.createBoard(dimension);
        threeByThree.updateCell(threeByThree.getCell(0,2), X);
        threeByThree.updateCell(threeByThree.getCell(1,1), X);
        threeByThree.updateCell(threeByThree.getCell(2,0), X);

        assertTrue(threeByThree.diagonalWin());
        assertEquals(X, threeByThree.getMarkerWon());
        System.out.println(threeByThree);
    }

    @Test
    public void testBoardFull() {
        int dimension = 2;
        Board board = boardFactory.createBoard(dimension);

        board.updateCell(board.getCell(0,0), X);
        board.updateCell(board.getCell(1,1), X);
        board.updateCell(board.getCell(0,1), X);
        board.updateCell(board.getCell(1,0), X);

        assertTrue(board.isFull());
    }
}
