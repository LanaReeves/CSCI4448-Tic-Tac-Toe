package tictactoe.player;

import tictactoe.Marker;
import tictactoe.strategy.IWinStrategy;

public class PlayerFactory {

    public Player createEasyBot(String name, Marker marker) {
        return new EasyBotPlayer(name, marker);
    }

    public Player createHardBot(String name, Marker marker, IWinStrategy winStrategy) {
        return new HardBotPlayer(name, marker, winStrategy);
    }
    public Player createHardBot(String name, Marker marker) {
        return new HardBotPlayer(name, marker);
    }

    public Player createHumanPlayer(Marker marker) {
        return new HumanPlayer(marker);
    }
}
