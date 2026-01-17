package designPattern.overloading;

public class A {
    public void print() {
        System.out.printf("Hello World\n");
    }

    public void print(String name) {
        System.out.printf("Hello" + " " + name);
    }
}
