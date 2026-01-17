package company_interview.SixthSense;

import java.util.*;

/*
   employeeID	    name	    managerID
1	              John Doe	    NULL
2	            Jane Smith	   1
3	            Jim Brown	   1
4	            Lucy Grey	   2
5	            Mark Green	   2
6	            Anna Blue	   3

Output
==============
John Doe
   |---------Jane Smith
   |          |
              |--------Lucy Grey
   |          |--------Mark Green
   |
   |----------Jim Brown
   |          |
   |          |---------------Anna Blue
 */
public class R1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sandeep", 0),
                new Employee(2, "Shivam", 1),
                new Employee(3, "Lucky", 1),
                new Employee(4, "Amit", 2),
                new Employee(5, "Gaurav", 2),
                new Employee(6, "Shobhit", 3)
        );

        Map<Integer, List<Employee>> employeeMap = buildEmployeeTree(employees);

        printEmployeeHierarchy(employeeMap, 0, "");
    }

    private static Map<Integer, List<Employee>> buildEmployeeTree(List<Employee> employees) {
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();

        for (Employee emp : employees) {
            employeeMap.computeIfAbsent(emp.getManagerId(), k -> new ArrayList<>()).add(emp);
        }

        return employeeMap;
    }

    // Apply DFS
    private static void printEmployeeHierarchy(Map<Integer, List<Employee>> employeeMap, int managerId, String prefix) {
        List<Employee> employees = employeeMap.get(managerId);

        if (employees != null) {
            for (Employee emp : employees) {
                System.out.println(prefix + emp.getEmpName());
                printEmployeeHierarchy(employeeMap, emp.getEmpId(), prefix + "   |---------");
            }
        }
    }

    public static class Employee {
        int empId;
        String empName;
        int managerId;

        public Employee(int empId, String empName, int managerId) {
            this.empId = empId;
            this.empName = empName;
            this.managerId = managerId;
        }

        public int getEmpId() {
            return empId;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public int getManagerId() {
            return managerId;
        }

        public void setManagerId(int managerId) {
            this.managerId = managerId;
        }
    }
}
