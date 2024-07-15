package DSA.implementDataStructure.createStack;


public class ArrayStack <T>{
    private T[] stack;
    private int top;
    private int size;
    private int capacity;

    public ArrayStack( int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.top = -1;
        this.size = 0;
        this.capacity = capacity;
    }
    public void push(T data){
        if(this.isFull()) throw new IllegalArgumentException("Stack is Full");
        stack[++top] = data;
        size++;
    }
    public T pop(){
        if(this.isEmpty()) throw new IllegalArgumentException("Stack is Empty");
        T data = stack[top];
        top--;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;

    }
    public int size(){
        return size;
    }
    public boolean isFull(){
        return size==capacity;
    }
    public T top(){
        if(this.isEmpty()) throw new IllegalArgumentException("Stack is Empty");
        return stack[top];
    }
}
