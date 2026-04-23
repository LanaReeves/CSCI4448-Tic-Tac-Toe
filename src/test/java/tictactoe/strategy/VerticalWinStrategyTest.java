package tictactoe.strategy;

import org.junit.jupiter.api.Test;
import tictactoe.ITicTacToe;
import tictactoe.TicTacToe;
import tictactoe.player.PlayerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerticalWinStrategyTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    void testVerticalWin() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().verticalWin().build();

        // First round moves
        game.pickMove(1,1);
        game.pickMove(1,2);

        // Second round moves
        game.pickMove(2,1);
        game.pickMove(2,2);

        // Third round move
        game.pickMove(0,1);

        assertTrue(game.isOver());
    }

    @Test
    void testVerticaNolWin() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().verticalWin().build();

        // First round moves
        game.pickMove(1,1);
        game.pickMove(2,2);

        // Second round moves
        game.pickMove(1,2);
        game.pickMove(0,0);

        // Third round move
        game.pickMove(1,0);

        assertFalse(game.isOver());
    }
}
