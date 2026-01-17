package designPattern.designPattern.behavioralDesignPattern.strategy.v1;

public class BikePathCalculationStrategy implements PathCalculationStrategy {
    @Override
    public void calculatePath(String from, String to) {
        System.out.println("Finding Path for Bike");
    }
}
