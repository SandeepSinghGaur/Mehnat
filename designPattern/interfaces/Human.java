package designPattern.interfaces;

public class Human extends Mammel implements Omnivore{
    @Override
    public void eatAnimal() {
        System.out.printf("Human is eating the Animal\n");
    }

    @Override
    public void eatPlant() {
        System.out.printf("Human is eating Plant\n");
    }
}
