package designPattern.polymorphism;

public class TA extends User {
    private String expertise;
    private String company;

    void takeHelpRequest(){}
    void updateEmail(){
        System.out.printf("Change Email of TA\n");
    }

}
