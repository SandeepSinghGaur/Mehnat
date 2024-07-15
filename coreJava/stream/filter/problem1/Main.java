package coreJava.stream.filter.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> emplyee = Arrays.asList(new Employee("Sandeep",1000,"IT"),
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 80000, "Engineering"),
                new Employee("Charlie", 60000, "HR"),
                new Employee("David", 75000, "Finance"),
                new Employee("Eve", 70000, "Engineering"));
       List<String> emplyess = emplyee.stream()
                .filter(employee -> employee.getDepartment()=="IT" && employee.getSalary()>=1000)
                .map(employee -> employee.getName()).collect(Collectors.toList());
        System.out.println(emplyess);
    }
}
