package tictactoe;

import org.junit.jupiter.api.Test;
import tictactoe.board.BoardFactory;
import tictactoe.player.PlayerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static tictactoe.Marker.X;

public class TicTacToeTest {
    BoardFactory boardFactory = new BoardFactory();
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void testTwoBots() {
        TicTacToe game = TicTacToe.getNewBuilder(boardFactory, playerFactory)
                .boardSize(3)
                .firstPlayerBot()
                .secondPlayerBot().build();

        game.play();

        assertTrue(game.isOver());
    }

    @Test
    public void test100Games() {
        int player1Wins = 0;
        int player2Wins = 0;
        int ties = 0;

        for (int i = 0; i < 100; i++) {
            TicTacToe game = TicTacToe.getNewBuilder(boardFactory, playerFactory)
                    .boardSize(3)
                    .firstPlayerBot()
                    .secondPlayerBot().build();

            game.play();

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
