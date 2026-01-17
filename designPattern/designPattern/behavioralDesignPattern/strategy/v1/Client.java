package designPattern.designPattern.behavioralDesignPattern.strategy.v1;

public class Client {
    public static void main(String[] args) {
         GoogleMaps googleMaps = new GoogleMaps();
         googleMaps.findPath("HSR","RGA",TransportMode.BIKE);
         System.out.println("Done");
    }
}
