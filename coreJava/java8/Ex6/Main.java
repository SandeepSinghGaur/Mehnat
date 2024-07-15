package coreJava.java8.Ex6;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(new Employee("Sandeep",100),
                new Employee("Vikas",1000),
                new Employee("Deepu",3000));
        int salary = employee.stream().mapToInt(Employee::getSalary).sum();
        System.out.println(salary);
    }
}
