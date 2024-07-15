package coreJava.java8.Ex3;

public class Main {
    public static void main(String[] args) {
        GetLength length = s->s.length();
        System.out.println(length.getLength("Sandeep"));
        System.out.println(length.getLength("Vikas"));
    }
}
