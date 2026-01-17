package designPattern.designPattern.structuralDesignPattern.flyweight.v0;


import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Bullet> bullets = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Bullet bullet = new Bullet();
            bullets.add(bullet);
        }
        System.out.println("bullets"+" "+bullets);
    }
}
