package tictactoe;

import org.slf4j.Logger;
import tictactoe.board.Board;
import tictactoe.board.Cell;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;

import java.util.Scanner;

public class TicTacToe implements ITicTacToe {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(TicTacToe.class);
    private Player player1;
    private Player player2;
    private Board board;
    private static final Marker PLAYER_1_MARKER = Marker.X;
    private static final Marker PLAYER_2_MARKER = Marker.O;
    private Player currentPlayer;
    private Player winningPlayer;

    private TicTacToe() {}

    public void playTurn(){
        Cell selectedCell = currentPlayer.move(board);
        board.updateCell(selectedCell, currentPlayer.getMarker());

        updatePlayer();
    }

    private void updatePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    @Override
    public boolean isOver() {
        return win() || tie();
    }

    private boolean win() {
        if (board.diagonalWin() || board.horizontalWin() || board.verticalWin()) {
            if (board.getMarkerWon() == PLAYER_1_MARKER) {
                winningPlayer = player1;
            }
            else {
                winningPlayer = player2;
            }
            logger.info("{} has won!", winningPlayer.getName());
            return true;
        }
        return false;
    }

    private boolean tie() {
        if (board.isFull()) {
            logger.info("There is a tie");
            return true;
        }
        return false;
    }

    @Override
    public Player getWinningPlayer() {
        return winningPlayer;
    }

    @Override
    public String getWinningPlayersName() {
        return winningPlayer.getName();
    }

    @Override
    public boolean currentPlayerIsHuman() {
        return currentPlayer.isHuman();
    }

    @Override
    public boolean player1IsHuman() {
        return player1.isHuman();
    }

    @Override
    public boolean player2IsHuman() {
        return player2.isHuman();
    }

    @Override
    public void enterPlayer1Name(String name) {
        player1.setName(name);
    }

    @Override
    public void enterPlayer2Name(String name) {
        player2.setName(name);
    }

    @Override
    public Board getBoard() {
        return board;
    }


    public static Builder getNewBuilder(PlayerFactory playerFactory) {
        return new Builder(playerFactory);
    }

    public static class Builder {
        final TicTacToe game = new TicTacToe();
        private final PlayerFactory playerFactory;

        private Builder(PlayerFactory playerFactory) {
            this.playerFactory = playerFactory;
        }

        public Builder firstPlayerBot() {
            String player1BotName = "Bot 1";
            game.player1 = playerFactory.createBot(player1BotName, PLAYER_1_MARKER);
            return this;
        }

        public Builder secondPlayerBot() {
            String player2BotName = "Bot 2";
            game.player2 = playerFactory.createBot(player2BotName, PLAYER_2_MARKER);
            return this;
        }

        public Builder firstPlayerHuman(Scanner scanner) {
            game.player1 = playerFactory.createHumanPlayer(PLAYER_1_MARKER, scanner);
            return this;
        }

        public Builder secondPlayerHuman(Scanner scanner) {
            game.player2 = playerFactory.createHumanPlayer( PLAYER_2_MARKER, scanner);
            return this;
        }

        public Builder boardSize(int size) {
            game.board = newBoard(size);
            return this;
        }

        private static Board newBoard(int size) {
            return new Board(size);
        }

        public TicTacToe build() {
            game.currentPlayer = game.player1;
            return game;
        }
    }
}
