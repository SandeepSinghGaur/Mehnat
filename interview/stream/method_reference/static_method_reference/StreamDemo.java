package interview.stream.method_reference.static_method_reference;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static int getLength(String str){
     
        return str.length();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("done","world","practice","fake");
        //list.stream().mapToInt(s->StreamDemo.getLength(s)).forEach(System.out::println);
        list.stream().mapToInt(StreamDemo::getLength).forEach(System.out::println);
    }
}
