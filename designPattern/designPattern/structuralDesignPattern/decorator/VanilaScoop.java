package designPattern.designPattern.structuralDesignPattern.decorator;

public class VanilaScoop implements IceCreamCone{
    private IceCreamCone iceCreamCone;

    public VanilaScoop(IceCreamCone iceCreamCone) {
        this.iceCreamCone = iceCreamCone;
    }

    @Override
    public int getCost() {
        return this.iceCreamCone.getCost() + 15;
    }

    @Override
    public String getConstituents() {
        return this.iceCreamCone.getConstituents() + " Vanila";
    }
}
