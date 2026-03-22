package tictactoe;

import org.slf4j.Logger;
import tictactoe.board.Board;
import tictactoe.board.BoardFactory;
import tictactoe.board.Cell;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;

public class TicTacToe {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(TicTacToe.class);
    private Player player1;
    private Player player2;
    private Board board;
    private static final Marker PLAYER_1_MARKER = Marker.X;
    private static final Marker PLAYER_2_MARKER = Marker.O;
    private Player currentPlayer;
    private Player winningPlayer;

    private TicTacToe() {}

    public void play() {
        currentPlayer = player1;
        while (!isOver()) {
            playTurn();
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }
            else {
                currentPlayer = player1;
            }
        }
    }

    private void playTurn(){
        Cell selectedCell = currentPlayer.move(board);
        board.updateCell(selectedCell, currentPlayer.getMarker());
    }

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

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public static Builder getNewBuilder(BoardFactory boardFactory, PlayerFactory playerFactory) {
        return new Builder(boardFactory, playerFactory);
    }

    public static class Builder {
        final TicTacToe game = new TicTacToe();
        private final PlayerFactory playerFactory;
        private final BoardFactory boardFactory;

        private Builder(BoardFactory boardFactory, PlayerFactory playerFactory) {
            this.boardFactory = boardFactory;
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

        public Builder firstPlayerHuman(String name) {
            game.player1 = playerFactory.createHumanPlayer(name, PLAYER_1_MARKER);
            return this;
        }

        public Builder secondPlayerHuman(String name) {
            game.player2 = playerFactory.createHumanPlayer(name, PLAYER_2_MARKER);
            return this;
        }

        public Builder boardSize(int size) {
            game.board = boardFactory.createBoard(size);
            return this;
        }

        public TicTacToe build() {
            return game;
        }
    }
}
