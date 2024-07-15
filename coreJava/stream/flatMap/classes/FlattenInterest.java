package coreJava.stream.flatMap.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlattenInterest {
    public static void main(String[] args) {
        List<Person> person = Arrays.asList(new Person("Alice", Arrays.asList("Reading", "Music")),
                new Person("Bob", Arrays.asList("Sports", "Movies", "Cooking")),
                new Person("Charlie", Arrays.asList("Traveling","Reading", "Photography")));
        Set<String> allInterest = person.stream().flatMap(e->e.getInterests().stream()).collect(Collectors.toSet());
        System.out.println(allInterest);

    }
}
