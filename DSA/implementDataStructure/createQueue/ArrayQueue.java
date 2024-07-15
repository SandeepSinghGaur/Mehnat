package DSA.implementDataStructure.createQueue;

public class ArrayQueue <T>{
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue( int capacity) {
        queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    public T[] getQueue() {
        return queue;
    }

    public void setQueue(T[] queue) {
        this.queue = queue;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void enqueue(T data) throws Exception {
        if(size==capacity) throw new Exception("Queue is Full");
        rear = (rear+1)%capacity;
        queue[rear] = data;
        size++;

    }
    public T dequeue() throws Exception {
        if(size==0) throw new Exception("Queue is empty");
        T data = queue[front];
        front = (front+1)%capacity;
        size--;
        return data;
    }
    public T peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.queue[this.front];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }

    // Method to return the size of the queue
    public int size() {
        return size;
    }

}
