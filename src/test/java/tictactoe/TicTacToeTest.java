package tictactoe;

import org.junit.jupiter.api.Test;
import tictactoe.board.Cell;
import tictactoe.player.PlayerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tictactoe.Marker.X;

public class TicTacToeTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void testTwoBots() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerEasyBot()
                .secondPlayerEasyBot().standardWin().build();

        while (!game.isOver()) {
            game.pickMove();
        }

        assertTrue(game.isOver());
    }

    @Test
    public void test100Games() {
        int player1Wins = 0;
        int player2Wins = 0;
        int ties = 0;

        for (int i = 0; i < 100; i++) {
            ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                    .boardSize(3)
                    .firstPlayerEasyBot()
                    .secondPlayerEasyBot()
                    .standardWin().build();

            while (!game.isOver()) {
                game.pickMove();
            }
            if (game.getWinningPlayer() == null) {
                ties++;
            } else if (game.getWinningPlayer().getMarker() == X) {
                player1Wins++;
            }
            else {
                player2Wins++;
            }
        }
        System.out.println("Ties: " + ties);
        System.out.println("Player 1 wins: " + player1Wins);
        System.out.println("Player 2 wins: " + player2Wins);
    }

    @Test
    public void testUndo() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().standardWin().build();

       game.pickMove(1,1);

       assertTrue(game.canUndo());

       game.undoMove();

       List<Cell> emptyCells = game.getBoard().getEmptyCells();
       assertEquals(game.getBoard().getDimension() * game.getBoard().getDimension(), emptyCells.size());
    }


    @Test
    void testHumanPlayersInGame() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().standardWin().build();

        game.enterPlayer1Name("Sam");
        game.enterPlayer2Name("Lana");

        assertTrue(game.player1IsHuman());
        assertTrue(game.player2IsHuman());
    }

    @Test
    void testWinningPlayer() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerHuman()
                .secondPlayerHuman().standardWin().build();

        game.enterPlayer1Name("Sam");
        // First round moves
        game.pickMove(1,1);
        game.pickMove(1,2);

        // Second round moves
        game.pickMove(2,2);
        game.pickMove(1,0);

        // Third round move
        game.pickMove(0,0);

        assertEquals("Sam", game.getWinningPlayersName());
        assertTrue(game.isOver());
    }
}
