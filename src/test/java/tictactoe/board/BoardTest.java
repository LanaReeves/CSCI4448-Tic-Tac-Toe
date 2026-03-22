package tictactoe.board;
import org.junit.jupiter.api.Test;
import tictactoe.Marker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BoardTest {
    CellFactory cellFactory = new CellFactory();

    @Test
    public void boardCreation() {
        int dimension = 3;
        Board threeByThree = new Board(dimension, cellFactory);
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
}
