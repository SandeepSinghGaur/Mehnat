package designPattern.designPattern.creationalDesignPattern.prototype.v1;

public class Sparrow extends Bird{

    private String legSize;

    public void setLegSize(String legSize) {
        this.legSize = legSize;
    }

    public Sparrow(){}
    public Sparrow(Sparrow old) {
        super(old);
        this.legSize = old.legSize;
    }

    public Sparrow clone(){
        return new Sparrow(this);
    }
}
