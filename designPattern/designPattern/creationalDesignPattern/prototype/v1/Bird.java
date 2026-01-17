package designPattern.designPattern.creationalDesignPattern.prototype.v1;

public class Bird implements Clonable<Bird>{
    private String name;
    private String color;
    private String weight;
    public Bird(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Bird(Bird old){
        this.name = old.name;
        this.weight = old.weight;
        this.color = old.color;
    }
    @Override
    public Bird clone() {
      return new Bird(this);
    }
}
