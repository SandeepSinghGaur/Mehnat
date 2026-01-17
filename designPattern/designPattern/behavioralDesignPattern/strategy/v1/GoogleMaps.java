package designPattern.designPattern.behavioralDesignPattern.strategy.v1;

public class GoogleMaps {

    public void findPath(String from , String to , TransportMode mode){
     PathCalculationStrategy pathCalculationStrategy =  PathCalculationStrategyFactory.getPathCalculationStrategyForMode(mode);
     pathCalculationStrategy.calculatePath(from,to);

    }
}
