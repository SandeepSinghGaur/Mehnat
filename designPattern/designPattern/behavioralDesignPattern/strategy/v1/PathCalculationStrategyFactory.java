package designPattern.designPattern.behavioralDesignPattern.strategy.v1;


public class PathCalculationStrategyFactory {
    public static PathCalculationStrategy getPathCalculationStrategyForMode(TransportMode mode){
        switch (mode) {
            case CAR:
                return new CarPathCalculationStrategy();
            case BIKE:
                return new BikePathCalculationStrategy();
            case WALK:
                return new WalkPathCalculationStrategy();
        }
        throw new RuntimeException("Invalid MODE "+mode);
    }
}
