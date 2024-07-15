package DSA.implementDataStructure.createStack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Object> stack = new ArrayStack<>(5);
        stack.push(4);
        stack.push(5);
        stack.push(10);
        System.out.println(STR."top: \{stack.top()}");
        System.out.println(STR."pop: \{stack.pop()}");
        System.out.println(STR."pop: \{stack.pop()}");
        System.out.println(STR."top: \{stack.top()}");
        System.out.println(STR."size: \{stack.size()}");
        stack.push(20);
        System.out.println(STR."top: \{stack.top()}");
        System.out.println(STR."size: \{stack.size()}");
    }
}
