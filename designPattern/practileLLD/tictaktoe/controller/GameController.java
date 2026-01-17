package designPattern.practileLLD.tictaktoe.controller;



import designPattern.practileLLD.tictaktoe.Exception.DuplicateSymbolException;
import designPattern.practileLLD.tictaktoe.Exception.MoreThanOneBotPlayerException;
import designPattern.practileLLD.tictaktoe.Exception.PlayerCountDimensionMisMatchException;
import designPattern.practileLLD.tictaktoe.model.Game;
import designPattern.practileLLD.tictaktoe.model.GameState;
import designPattern.practileLLD.tictaktoe.model.Player;
import designPattern.practileLLD.tictaktoe.strategy.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayerCountDimensionMisMatchException, DuplicateSymbolException, MoreThanOneBotPlayerException {
        return Game.getBuilder()
                .setDimension(boardDimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }

    public void makeMove(Game game) {
        game.makeMove();

    }

    public GameState checkState(Game game) {
        return game.getGameState();

    }

    public void undoTheLastMove() {

    }

    public void getWinner() {

    }

    public void printBoard(Game game) {
        game.printBoard();

    }
}
