package coreJava.core_java_concept.oops.finalPackage;

public class Child extends Parent{

//    public void marry(){
//        System.out.println("Child Married ILA");
//    }

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Child();
        parent.marry();
        child.marry();
    }
}
