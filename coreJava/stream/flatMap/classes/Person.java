package coreJava.stream.flatMap.classes;

import java.util.List;

public class Person {
    private String name;
    private List<String> interests;

    public Person(String name, List<String> interests) {
        this.name = name;
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return STR."Person{name='\{name}\{'\''}, interests=\{interests}\{'}'}";
    }
}
