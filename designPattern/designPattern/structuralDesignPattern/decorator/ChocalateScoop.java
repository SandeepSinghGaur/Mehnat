package designPattern.designPattern.structuralDesignPattern.decorator;

public class ChocalateScoop implements IceCreamCone{
    private IceCreamCone iceCreamCone;

    public ChocalateScoop(IceCreamCone iceCreamCone) {
        this.iceCreamCone = iceCreamCone;
    }

    @Override
    public int getCost() {
        return iceCreamCone.getCost() + 20;
    }

    @Override
    public String getConstituents() {
        return iceCreamCone.getConstituents() + " Chocolate";
    }
}
