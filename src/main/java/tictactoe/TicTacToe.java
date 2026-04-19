package tictactoe;

import org.slf4j.Logger;
import tictactoe.board.Board;
import tictactoe.board.Cell;
import tictactoe.commands.ICommand;
import tictactoe.commands.MoveCommand;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;
import tictactoe.strategy.IWinStrategy;
import tictactoe.strategy.WinStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements ITicTacToe {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(TicTacToe.class);
    private Player player1;
    private Player player2;
    private Board board;
    private static final Marker PLAYER_1_MARKER = Marker.X;
    private static final Marker PLAYER_2_MARKER = Marker.O;
    private Player currentPlayer;
    private Player winningPlayer;
    private IWinStrategy winStrategy;
    private boolean winOccurred = false;
    List<ICommand> moveCommands = new ArrayList<>();


    private TicTacToe() {}

    public void pickMove() {
        Cell selectedCell = currentPlayer.move(board);
        playTurn(selectedCell);
    }

    public void pickMove(int row, int col) {
        Cell selectedCell = currentPlayer.move(board, row, col);
        playTurn(selectedCell);
    }

    private void playTurn(Cell selectedCell){
        ICommand moveCommand = new MoveCommand(board, selectedCell, currentPlayer);
        boolean updated = moveCommand.execute();
        moveCommands.add(moveCommand);

        if (updated) {
            if (win()) {
                winOccurred = true;
            }
            updatePlayer();
        }
    }


    public void undoMove() {
        if (!moveCommands.isEmpty()) {
            undoCommand();

            if(!currentPlayerIsHuman() && !moveCommands.isEmpty()) {
                undoCommand();
            }
        }
    }

    private void undoCommand() {
        ICommand move = moveCommands.getLast();
        move.undo();
        moveCommands.removeLast();
        currentPlayer = move.getPlayer();
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
        return winOccurred|| tie();
    }

    private boolean win() {
        if (winStrategy.checkWin(board)) {
            winningPlayer = currentPlayer;
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

    public static TicTacToe.Builder getNewBuilder(PlayerFactory playerFactory) {
        return new TicTacToe.Builder(playerFactory);
    }

    public static class Builder  {
        final TicTacToe game = new TicTacToe();
        private final PlayerFactory playerFactory;
        static private final WinStrategyFactory winStrategyFactory = new WinStrategyFactory();

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

        public Builder firstPlayerHuman() {
            game.player1 = playerFactory.createHumanPlayer(PLAYER_1_MARKER);
            return this;
        }

        public Builder secondPlayerHuman() {
            game.player2 = playerFactory.createHumanPlayer( PLAYER_2_MARKER);
            return this;
        }

        public Builder standardWin() {
            game.winStrategy = winStrategyFactory.newStandardWinStrategy();
            return this;
        }

        public Builder verticalWin() {
            game.winStrategy = winStrategyFactory.newVerticalWinStrategy();
            return this;
        }

        public Builder horizontalWin() {
            game.winStrategy = winStrategyFactory.newHorizontalWinStrategy();
            return this;
        }

        public Builder diagonalWin() {
            game.winStrategy = winStrategyFactory.newDiagonalWinStrategy();
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
