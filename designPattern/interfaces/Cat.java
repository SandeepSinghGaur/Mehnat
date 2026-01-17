package designPattern.interfaces;

public class Cat implements Carnivore{
    @Override
    public void eatAnimal() {
        System.out.printf("Cat is eating the Animal\n");
    }
}
