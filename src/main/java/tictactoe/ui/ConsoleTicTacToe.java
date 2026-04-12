package tictactoe.ui;

import tictactoe.ITicTacToe;
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
                System.out.print("Enter coordinate: ");
            }
            else {
                System.out.println("Bot is playing");
            }

            ticTacToe.playTurn();
        }

        System.out.println(ticTacToe.getBoard());
    }

    private void setUpGame() {
        boolean validGameInput;

        do {
            System.out.print("Please select a opponent (1 = Bot, 2 = Human Player): ");
            int gameType = scanner.nextInt();

            if (gameType == 1) {
                this.ticTacToe = getNewBuilder(playerFactory).firstPlayerHuman(scanner).secondPlayerBot().boardSize(3).build();
                validGameInput = true;
            } else if (gameType == 2) {
                this.ticTacToe = getNewBuilder(playerFactory).firstPlayerHuman(scanner).secondPlayerHuman(scanner).boardSize(3).build();
                validGameInput = true;
            } else {
                System.out.println("Wrong input.");
                validGameInput = false;
            }
        } while(!validGameInput);
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
