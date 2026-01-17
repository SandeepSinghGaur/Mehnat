package designPattern.designPattern.creationalDesignPattern.prototype.v1;

public class Crow extends Bird{
    private String sound = "cow";

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Crow(){}
    public Crow(Crow old) {
        super(old);
        this.sound = old.sound;
    }

    public Crow clone(){

        return new Crow(this);
    }

}
