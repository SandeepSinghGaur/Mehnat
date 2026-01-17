package designPattern.overridding;

public class B extends A{

    public void doSomething(){
// if we want to execute the parents doSomething() method  we can use super()
        super.doSomething();
        System.out.printf("Class B Method\n");
    }
}
