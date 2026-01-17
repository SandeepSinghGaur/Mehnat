package designPattern.designPattern.behavioralDesignPattern.strategy.v2;

public class WalkPathCalculationStrategy implements PathCalculationStrategy {
    @Override
    public void calculatePath(String from, String to) {
        System.out.println("Finding Path for Walk");
    }
}
