package designPattern.designPattern.structuralDesignPattern.flyweight.v1;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    private Map<BulletType,Bullet> bullets = new HashMap<>();
    public void registerBullet(BulletType bulletType,Bullet bullet){
        bullets.put(bulletType,bullet);
    }
    public Bullet getBullet(BulletType bulletType){
        return bullets.get(bulletType);
    }
}
