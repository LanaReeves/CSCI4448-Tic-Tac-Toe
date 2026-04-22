package tictactoe.strategy;

import org.junit.jupiter.api.Test;
import tictactoe.ITicTacToe;
import tictactoe.TicTacToe;
import tictactoe.player.PlayerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiagonalWinStrategyTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    void testDiagonalWin() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().diagonalWin().build();

        // First round moves
        game.pickMove(1,1);
        game.pickMove(1,2);

        // Second round moves
        game.pickMove(2,2);
        game.pickMove(1,3);

        // Third round move
        game.pickMove(3,3);

        assertTrue(game.isOver());
    }

    @Test
    void testDiagonalNoWin() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().diagonalWin().build();

        // First round moves
        game.pickMove(1,1);
        game.pickMove(1,2);

        // Second round moves
        game.pickMove(2,1);
        game.pickMove(1,3);

        // Third round move
        game.pickMove(3,1);

        assertFalse(game.isOver());
    }
}
