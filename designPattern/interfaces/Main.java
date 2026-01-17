package designPattern.interfaces;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hervivore> hervivores = List.of(
                new Human(),
                new Dog()
        );
        for(Hervivore hervivore : hervivores){
            hervivore.eatPlant();
        }
    }
}
