package designPattern.designPattern.creationalDesignPattern.prototype;

import designPattern.birdProblemv0.Type;

public abstract class Birds {
    private String color;
    private double weight;
    private Type type;
    private double size;
    public abstract Birds copy();

}
