package tictactoe.player;

import tictactoe.Marker;

public class HumanPlayer extends Player{

    public HumanPlayer(Marker marker) {
        super(marker);
    }

    @Override
    public boolean isHuman() {
        return true;
    }

}
