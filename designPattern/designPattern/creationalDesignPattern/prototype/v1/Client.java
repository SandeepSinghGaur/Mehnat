package designPattern.designPattern.creationalDesignPattern.prototype.v1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Bird b1 = new Bird();
        b1.setColor("White");
        b1.setName("Sandeep");
        b1.setWeight("70");
        Sparrow s1 = new Sparrow();
        s1.setColor("Blue");
        s1.setLegSize("hii");
        Crow c1 = new Crow();
        c1.setSound("twik twik");
        c1.setWeight("100Kg");
        List<Bird> birds = List.of(
                b1,
                s1,
                c1
        );
        List<Bird> children = new ArrayList<>();
        for (Bird b : birds) {
            children.add(b.clone());
        }
        for (Bird child : children) {
            child.setName("It ia a copy");
        }
        Sparrow longLangSparrow = new Sparrow();
        longLangSparrow.setLegSize("10000");
        Crow sweetSoundCrow = new Crow();
        sweetSoundCrow.setSound("swwwwwet sount");
        BirdRegistry birdRegistry = new BirdRegistry();
        birdRegistry.registerBird("longlangSparrow", longLangSparrow);
        birdRegistry.registerBird("sweetSoundCrow", sweetSoundCrow);
        List<String> getRegistryBird = List.of(
                "sweetSoundCrow",
                "longlangSparrow");
        List<Bird> requestedBird = new ArrayList<>();
        for (String type : getRegistryBird) {
            requestedBird.add(birdRegistry.getBird(type));
        }
        System.out.printf("Done");


    }
}
