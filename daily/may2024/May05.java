package daily.may2024;

public class May05 {
    Node head = null;
    Node tail = null;
    int size = 0;
    public static void main(String[] args) {
        createLinkedList();
        //deleteNodeInLinkedList();
    }

    private static void createLinkedList() {
        Node node1 = new Node(2);


    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

    }
}
