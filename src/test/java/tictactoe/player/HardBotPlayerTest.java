package tictactoe.player;

import org.junit.jupiter.api.Test;
import tictactoe.ITicTacToe;
import tictactoe.Marker;
import tictactoe.TicTacToe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HardBotPlayerTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    void testCenterMove() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .standardWin()
                .firstPlayerHuman()
                .secondPlayerHardBot().build();

        game.pickMove(0,0);
        game.pickMove();

        assertEquals(Marker.O, game.getBoard().getCell(1,1).getMarker());
    }

    @Test
    void testCornerMove() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHardBot().standardWin().build();

        game.pickMove(1, 1);
        game.pickMove();

        assertEquals(Marker.O, game.getBoard().getCell(0,0).getMarker());
    }

    @Test
    void testBlockWinMove() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHardBot().standardWin().build();

        game.pickMove(0, 0);
        game.pickMove();

        game.pickMove(2, 0);
        game.pickMove();

        assertEquals(Marker.O, game.getBoard().getCell(1,0).getMarker());
    }

    @Test
    void testWinMove() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .secondPlayerHuman()
                .firstPlayerHardBot().standardWin().build();

        game.pickMove();
        game.pickMove(0,1);

        game.pickMove();
        game.pickMove(1,0);

        game.pickMove();

        assertTrue(game.isOver());
        assertTrue(game.getWinningPlayer().isHardBot());
    }

}
