package designPattern.interfaces;

public class Dog extends Mammel implements Hervivore {
    @Override
    public void eatPlant() {
        System.out.printf("Dog is eating the plant\n");
    }
}
