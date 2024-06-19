package interview.stream.method_reference.static_method_reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("done","world","practice","fake");
        //list.stream().mapToInt(s->StreamDemo.getLength(s)).forEach(System.out::println);
        list.stream().map(s->s.charAt(0)).forEach(System.out::println);
        String res = list.stream().collect(Collectors.joining());
        System.out.println(res);
    }
}
