package tictactoe.player;

import org.junit.jupiter.api.Test;
import tictactoe.board.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static tictactoe.Marker.X;

public class HumanPlayerTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    void humanPlayerTest() {
        Player human = playerFactory.createHumanPlayer(X);
        Board board = new Board(3);

        human.setName("Sam");
        assertEquals("Sam", human.getName());

        assertNull(human.move(board));
    }
}
