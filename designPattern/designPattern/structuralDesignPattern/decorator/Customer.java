package designPattern.designPattern.structuralDesignPattern.decorator;

public class Customer {
    public static void main(String[] args) {
        /*
           We can Say this is same like chain pattern
           We want to create an Icecream => which will contain OrangeCone-> on top(VanilaScoop->ontop->cholcateScopp->ontop->vabilaScoop))))
         */
        IceCreamCone iceCreamCone = new VanilaScoop(
                new ChocalateScoop(
                        new VanilaScoop(
                                new OrangeCone()
                        )));

        System.out.printf("IceCream Cost: %s%n", iceCreamCone.getCost());
        System.out.printf("IceCream Constituents: %s", iceCreamCone.getConstituents());

    }
}
