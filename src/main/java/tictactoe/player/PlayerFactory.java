package tictactoe.player;

import tictactoe.Marker;

import java.util.Scanner;

public class PlayerFactory {

    public Player createBot(String name, Marker marker) {
        return new BotPlayer(name, marker);
    }

    public Player createHumanPlayer(Marker marker, Scanner scanner) {
        return new HumanPlayer(marker, scanner);
    }
}
