package tictactoe.ui;

import tictactoe.ITicTacToe;
import tictactoe.TicTacToe;
import tictactoe.player.PlayerFactory;

import java.util.Scanner;

import static tictactoe.TicTacToe.getNewBuilder;

public class ConsoleTicTacToe {

    private final Scanner scanner = new Scanner(System.in);
    private ITicTacToe ticTacToe;

    private static final PlayerFactory playerFactory = new PlayerFactory();


    public ConsoleTicTacToe() {
        setUpGame();
    }

    public void play() {
        setUpNames();

        while (!ticTacToe.isOver()) {
            System.out.println(ticTacToe.getBoard());

            if (ticTacToe.currentPlayerIsHuman()) {
                System.out.print("Enter coordinate or 'u' for undo: ");
                String input = scanner.next();

                if (input.equals("u")) {
                    ticTacToe.undoMove();
                }
                else {
                   int row = Integer.parseInt(input);
                   int col = scanner.nextInt();

                   ticTacToe.pickMove(row - 1, col - 1);
                }
            }
            else {
                System.out.println("Bot is playing");
                ticTacToe.pickMove();
            }
        }

        System.out.println(ticTacToe.getBoard());
    }

    private void setUpGame() {
        boolean validGameInput;
        boolean validWinInput;

        TicTacToe.Builder builder = getNewBuilder(playerFactory).firstPlayerHuman().boardSize(3);

        do {
            System.out.print("Please select a win option (1 = Standard, 2 = Vertical, 3 = Diagonal, 4 = Horizontal): ");
            int winType = scanner.nextInt();

            if (winType == 1) {
                builder = builder.standardWin();
                validWinInput = true;
            } else if (winType == 2) {
                builder = builder.verticalWin();
                validWinInput = true;
            }
            else if (winType == 3) {
                builder = builder.diagonalWin();
                validWinInput = true;
            }
            else if (winType == 4) {
                builder = builder.horizontalWin();
                validWinInput = true;
            }
            else {
                System.out.println("Wrong input.");
                validWinInput = false;
            }
        } while(!validWinInput);

        do {
            System.out.print("Please select a opponent (1 = Easy Bot, 2 = Hard Bot, 3 = Human Player): ");
            int gameType = scanner.nextInt();

            if (gameType == 1) {
                builder = builder.secondPlayerEasyBot();
                validGameInput = true;
            } else if (gameType == 2) {
                builder = builder.secondPlayerHardBot();
                validGameInput = true;
            } else if (gameType == 3) {
                builder = builder.secondPlayerHuman();
                validGameInput = true;
            } else {
                System.out.println("Wrong input.");
                validGameInput = false;
            }
        } while(!validGameInput);

        System.out.print("Please input a number for the board size: ");
        int boardSize = scanner.nextInt();
        builder.boardSize(boardSize);


        this.ticTacToe = builder.build();
    }

    private void setUpNames() {
        if (ticTacToe.player1IsHuman()) {
            System.out.print("Enter player 1's Name: ");
            String name = scanner.next();
            ticTacToe.enterPlayer1Name(name);
        }

        if (ticTacToe.player2IsHuman()) {
            System.out.print("Enter player 2's Name: ");

            String name = scanner.next();
            ticTacToe.enterPlayer2Name(name);
        }

    }

    public static void main(String[] args) {
        new ConsoleTicTacToe().play();
    }
}
