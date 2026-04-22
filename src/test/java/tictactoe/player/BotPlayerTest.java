package tictactoe.player;

import org.junit.jupiter.api.Test;
import tictactoe.board.Board;
import tictactoe.board.Cell;

import static org.junit.jupiter.api.Assertions.*;
import static tictactoe.Marker.X;

public class BotPlayerTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void playerMove(){
        int dimension = 3;
        Player bot1 = playerFactory.createBot("bot1", X);
        Board board = new Board(dimension);

        Cell cellSelected = bot1.move(board);

        assertTrue((0 <= cellSelected.getX()) && (dimension > cellSelected.getX()));
        assertTrue((0 <= cellSelected.getY()) && (dimension > cellSelected.getY()));
        assertFalse(bot1.isHuman());
    }


}
