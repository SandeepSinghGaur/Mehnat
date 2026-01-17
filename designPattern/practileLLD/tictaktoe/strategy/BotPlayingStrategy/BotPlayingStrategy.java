package designPattern.practileLLD.tictaktoe.strategy.BotPlayingStrategy;

import designPattern.practileLLD.tictaktoe.model.Board;
import designPattern.practileLLD.tictaktoe.model.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
