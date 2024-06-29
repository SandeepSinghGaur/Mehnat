package company_interview.enfussion.L1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Sandeep","Singh",100),
                new Person("Vikas","Singh",100),
                new Person("Deepu","Singh",100),
                new Person("James","Singh",100),
                new Person("Virat","Singh",101),
                new Person("Sandeep","Singh",101),
                new Person("Sandeep","Singh",101),
                new Person("Sandeep","Singh",200),
                new Person("Vikas","Singh",100),
                new Person("Deepu","Singh",200),
                new Person("Virat","Singh",400)

        );
        printName(people);
    }

    private static void printName(List<Person> people) {
        HashMap<String, Set<Integer>> res = new HashMap<>();
        HashMap<String, Person> getPerson = new HashMap<>();

        for (Person person : people) {
            String p = person.getName() + person.getLname();
            res.putIfAbsent(p, new HashSet<>());
            res.get(p).add(person.getNumber());

            getPerson.putIfAbsent(p, person);
        }

        res.forEach((personKey, numbers) -> {
            Person p = getPerson.get(personKey);
            System.out.println(STR."\{p.getName()} \{p.getLname()} \{numbers.size()}");
        });
    }

}
