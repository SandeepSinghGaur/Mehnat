package designPattern.practileLLD.tictaktoe.model;


import designPattern.practileLLD.tictaktoe.Exception.DuplicateSymbolException;
import designPattern.practileLLD.tictaktoe.Exception.MoreThanOneBotPlayerException;
import designPattern.practileLLD.tictaktoe.Exception.PlayerCountDimensionMisMatchException;
import designPattern.practileLLD.tictaktoe.strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.players = players;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public Move makeMove() {
        Player currentMovePlayer = players.get(nextMovePlayerIndex);
        System.out.println(
                "current player name: " + currentMovePlayer.getName() +
                        " current player type: " + currentMovePlayer.getPlayerType()
        );
        return currentMovePlayer.makeMove();

    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private boolean validateBotCount() throws MoreThanOneBotPlayerException {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
                if (botCount > 1) {
                    throw new MoreThanOneBotPlayerException();
                }
            }
            return true;
        }

        private boolean validateDimensionAndPlayerCount() throws PlayerCountDimensionMisMatchException {
            if (players.size() != dimension - 1) {
                throw new PlayerCountDimensionMisMatchException();
            }
            return true;
        }

        private boolean validateUniqueSymbol() throws DuplicateSymbolException {
            for (Player player : players) {
                Map<Character, Integer> symbolCount = new HashMap<>();
                if (symbolCount.containsKey(player.getSymbol().getaChar())) {
                    symbolCount.put(player.getSymbol().getaChar(), symbolCount.get(player.getSymbol().getaChar()) + 1);
                } else {
                    symbolCount.put(player.getSymbol().getaChar(), 1);
                }
                if (symbolCount.get(player.getSymbol().getaChar()) > 1) {
                    throw new DuplicateSymbolException();
                }
            }
            return true;
        }

        private boolean validate() throws PlayerCountDimensionMisMatchException, DuplicateSymbolException, MoreThanOneBotPlayerException {
            try {
                validateBotCount();
                validateDimensionAndPlayerCount();
                validateUniqueSymbol();

            } catch (Exception exception) {
                throw exception;

            }
            return true;
        }
        public Game build() throws PlayerCountDimensionMisMatchException, DuplicateSymbolException, MoreThanOneBotPlayerException {
            try {
                validate();
            }catch (Exception e){
                throw e;
            }
            return new Game(this.dimension,this.players,this.winningStrategies);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
