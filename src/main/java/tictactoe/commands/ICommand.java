package tictactoe.commands;

import tictactoe.player.Player;

public interface ICommand {

    boolean execute();
    void undo();
    Player getPlayer();
}
