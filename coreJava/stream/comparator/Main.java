package coreJava.stream.comparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> student = new ArrayList<>();
            student.add(new Student("Sandeep",1,8.01));
            student.add(new Student("Vikas",2,9.01));
            student.add(new Student("Deepu",3,3.01));
            student.add(new Student("Samyak",4,5.0));
            student.add(new Student("Amit",5,5.0));


        Collections.sort(student, Comparator.comparing(Student::getCgpa).thenComparing(Student::getName).thenComparing(Student::getId));
        for(Student s : student){
            System.out.println(STR."Cgpa:  \{s.getCgpa()} \{s.getName()}");
        }

    }
}
