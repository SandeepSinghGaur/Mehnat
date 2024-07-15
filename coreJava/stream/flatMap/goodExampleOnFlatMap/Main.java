package coreJava.stream.flatMap.goodExampleOnFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Creating students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");
        Student s4 = new Student("David");

        // Creating courses
        Course c1 = new Course("Math", Arrays.asList(s1, s2));
        Course c2 = new Course("Physics", Arrays.asList(s3, s4));
        Course c3 = new Course("Chemistry", Arrays.asList(s1, s3));

        // Creating departments
        Department d1 = new Department("Science", Arrays.asList(c2, c3));
        Department d2 = new Department("Mathematics", Arrays.asList(c1));

        List<Department> department = Arrays.asList(d1,d2);
        List<String> names = department.stream().
                flatMap(department1->department1.getCourses().stream())
                .flatMap(course -> course.getStudents().stream())
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
