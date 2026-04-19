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
                .secondPlayerBot().standardWin().build();

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
                    .secondPlayerBot()
                    .standardWin().build();

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


    @Test
    public void testHorizontalWin() {
//        int dimension = 3;
//        Board threeByThree = new Board(dimension);
//        threeByThree.updateCell(threeByThree.getCell(0,0), X);
//        threeByThree.updateCell(threeByThree.getCell(0,1), X);
//        threeByThree.updateCell(threeByThree.getCell(0,2), X);
//
//        assertTrue(threeByThree.horizontalWin());
//        assertEquals(X, threeByThree.getMarkerWon());
//        System.out.println(threeByThree);
    }

    @Test
    public void testVerticalWin() {
//        int dimension = 3;
//        Board threeByThree = new Board(dimension);
//        threeByThree.updateCell(threeByThree.getCell(0,2), O);
//        threeByThree.updateCell(threeByThree.getCell(1,2), O);
//        threeByThree.updateCell(threeByThree.getCell(2,2), O);
//
//        assertTrue(threeByThree.verticalWin());
//        assertEquals(O, threeByThree.getMarkerWon());
//        System.out.println(threeByThree);
    }

    @Test
    public void testFirstDiagonalWin() {
//        int dimension = 3;
//        Board threeByThree = new Board(dimension);
//        threeByThree.updateCell(threeByThree.getCell(0,0), O);
//        threeByThree.updateCell(threeByThree.getCell(1,1), O);
//        threeByThree.updateCell(threeByThree.getCell(2,2), O);
//
//        assertTrue(threeByThree.diagonalWin());
//        assertEquals(O, threeByThree.getMarkerWon());
//        System.out.println(threeByThree);
    }

    @Test
    public void testSecondDiagonalWin() {
//        int dimension = 3;
//        Board threeByThree = new Board(dimension);
//        threeByThree.updateCell(threeByThree.getCell(0,2), X);
//        threeByThree.updateCell(threeByThree.getCell(1,1), X);
//        threeByThree.updateCell(threeByThree.getCell(2,0), X);
//
//        assertTrue(threeByThree.diagonalWin());
//        assertEquals(X, threeByThree.getMarkerWon());
//        System.out.println(threeByThree);
    }
}
