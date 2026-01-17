package designPattern.designPattern.behavioralDesignPattern.strategy.v0;

public class GoogleMaps {
    public void findPath(String from , String to , TransportMode mode){
        if(mode == TransportMode.CAR){
            System.out.println("Finding Path for Car");
        }else if(mode == TransportMode.BIKE){
            System.out.println("Finding Path for Bike");
        }else if(mode == TransportMode.WALK){
            System.out.println("Finding Path for Walk");
        }

    }
}
