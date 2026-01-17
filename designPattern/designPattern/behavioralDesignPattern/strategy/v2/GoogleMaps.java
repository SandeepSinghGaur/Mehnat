package designPattern.designPattern.behavioralDesignPattern.strategy.v2;



public class GoogleMaps {

    private PathCalculationStrategyRegistry pathCalculationStrategyRegistry;

    public GoogleMaps(PathCalculationStrategyRegistry pathCalculationStrategyRegistry) {
        this.pathCalculationStrategyRegistry = pathCalculationStrategyRegistry;
    }
    public void findPath(String from , String to , TransportMode mode){

        PathCalculationStrategy pathCalculationStrategy = pathCalculationStrategyRegistry.getRegistry(mode);
        pathCalculationStrategy.calculatePath(from,to);
    }
}
