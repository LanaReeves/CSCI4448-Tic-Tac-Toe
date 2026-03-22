package tictactoe.player;

import tictactoe.Marker;

public class PlayerFactory {

    public Player createBot(String name, Marker marker) {
        return new BotPlayer(name, marker);
    }

    public Player createHumanPlayer(String name, Marker marker) {
        return new HumanPlayer(name, marker);
    }
}
