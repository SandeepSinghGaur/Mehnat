package DSA.implementDataStructure.createQueue;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayQueue<Object> queue = new ArrayQueue<>(5);

        // Enqueue operations
        queue.enqueue(1);  // Queue: [1]
        queue.enqueue(2);  // Queue: [1, 2]
        queue.enqueue(3);  // Queue: [1, 2, 3]

        // Dequeue operations (FIFO: First-In-First-Out)
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 1
        System.out.println("Peek: " + queue.peek());       // Output: Peek: 2

        queue.enqueue(4);  // Queue: [2, 3, 4]
        queue.enqueue(5);  // Queue: [2, 3, 4, 5]
        queue.enqueue(6);  // Queue: [2, 3, 4, 5, 6]

        // Process all elements in FIFO order
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}
