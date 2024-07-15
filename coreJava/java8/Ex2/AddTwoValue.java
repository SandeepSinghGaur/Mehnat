package coreJava.java8.Ex2;

public class AddTwoValue {
    public static void main(String[] args) {
        Add add = (a,b)-> {return a+b;};
        System.out.println(add.add(2,3));
        System.out.println(add.add(20,30));
    }
}
