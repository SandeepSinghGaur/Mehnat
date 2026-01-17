package designPattern.designPattern.structuralDesignPattern.flyweight.v1;

public class FlyingBullet {
    private double radius;
    private double x_coord;
    private double y_coord;
    private double speed;
    private Long userId;
    private BulletStatus bulletStatus;
    private double x_dir;
    private double y_dir;
    private double z_dir;
    private Bullet bullet;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX_coord() {
        return x_coord;
    }

    public void setX_coord(double x_coord) {
        this.x_coord = x_coord;
    }

    public double getY_coord() {
        return y_coord;
    }

    public void setY_coord(double y_coord) {
        this.y_coord = y_coord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BulletStatus getBulletStatus() {
        return bulletStatus;
    }

    public void setBulletStatus(BulletStatus bulletStatus) {
        this.bulletStatus = bulletStatus;
    }

    public double getX_dir() {
        return x_dir;
    }

    public void setX_dir(double x_dir) {
        this.x_dir = x_dir;
    }

    public double getY_dir() {
        return y_dir;
    }

    public void setY_dir(double y_dir) {
        this.y_dir = y_dir;
    }

    public double getZ_dir() {
        return z_dir;
    }

    public void setZ_dir(double z_dir) {
        this.z_dir = z_dir;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
