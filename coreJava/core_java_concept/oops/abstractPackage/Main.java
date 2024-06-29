package coreJava.core_java_concept.oops.abstractPackage;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        int tyre = bus.noOfWheels();
        System.out.println("Tyres in the Bus:"+" " +tyre);
    }
}
