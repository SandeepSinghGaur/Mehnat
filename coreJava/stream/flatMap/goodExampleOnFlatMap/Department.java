package coreJava.stream.flatMap.goodExampleOnFlatMap;
import java.util.List;
public class Department {
    private String name;
    private List<Course> courses;

    public Department(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return STR."Department{name='\{name}\{'\''}, courses=\{courses}\{'}'}";
    }
}
