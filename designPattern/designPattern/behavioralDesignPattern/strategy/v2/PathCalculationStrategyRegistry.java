package designPattern.designPattern.behavioralDesignPattern.strategy.v2;


import java.util.HashMap;
import java.util.Map;

public class PathCalculationStrategyRegistry {
    private Map<TransportMode, PathCalculationStrategy> stratgyMap = new HashMap<>();
    public void register(TransportMode mode, PathCalculationStrategy strategy){
        stratgyMap.put(mode,strategy);
    }
    public PathCalculationStrategy getRegistry(TransportMode mode){
        return stratgyMap.get(mode);
    }
}
