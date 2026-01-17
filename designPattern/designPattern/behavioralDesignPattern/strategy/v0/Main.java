package designPattern.designPattern.behavioralDesignPattern.strategy.v0;

public class Main {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.findPath("HSR","Kormangla",TransportMode.CAR);
    }
}
