package designPattern.practileLLD.tictaktoe.model;

import designPattern.practileLLD.tictaktoe.strategy.BotPlayingStrategy.BotPlayingStrategy;
import designPattern.practileLLD.tictaktoe.strategy.BotPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, String name, Long id,  BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, id, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }

    public Bot(){

    }
    public Move makeMove(){
       return super.makeMove();
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
