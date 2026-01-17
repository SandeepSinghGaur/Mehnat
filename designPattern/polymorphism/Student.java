package designPattern.polymorphism;

public class Student extends User {
    private String batch;
    private double psp;
    Mentor mentor;

    void changeBatch(){

    }
    void updateEmail(){
        System.out.printf("Change Email of Student\n");
    }
}
