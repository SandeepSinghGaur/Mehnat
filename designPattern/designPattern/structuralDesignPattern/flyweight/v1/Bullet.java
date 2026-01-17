package designPattern.designPattern.structuralDesignPattern.flyweight.v1;

public class Bullet {

    private double weight;
    private BulletType bulletType;
    private Byte[] image;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BulletType getBulletType() {
        return bulletType;
    }

    public void setBulletType(BulletType bulletType) {
        this.bulletType = bulletType;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
