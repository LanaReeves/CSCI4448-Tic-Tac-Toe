package tictactoe;

import org.junit.jupiter.api.Test;
import tictactoe.player.PlayerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static tictactoe.Marker.X;

public class TicTacToeTest {
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void testTwoBots() {
        ITicTacToe game = TicTacToe.getNewBuilder(playerFactory)
                .boardSize(3)
                .firstPlayerBot()
                .secondPlayerBot().build();

        while (!game.isOver()) {
            game.playTurn();
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
                    .firstPlayerBot()
                    .secondPlayerBot().build();

            while (!game.isOver()) {
                game.playTurn();
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
}
