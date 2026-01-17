package designPattern.practileLLD.tictaktoe.strategy.BotPlayingStrategy;

import designPattern.practileLLD.tictaktoe.model.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
            case HARD:
                return new HardBotPlayingStrategy();
        }
        throw new RuntimeException("Please pass the correct strategy");
    }
}
