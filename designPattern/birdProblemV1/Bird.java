package designPattern.birdProblemV1;

// to have the comman Attributes and behavior of all the bird
public abstract class Bird {
    private double weight;
    private String colour;
    private Type type;
    private double size;
    public abstract void eat();
    public abstract void fly();
    public abstract void makeSound();

}
