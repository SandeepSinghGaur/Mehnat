package DSA.LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        // Create Linked List: 2 -> 4 -> 6 -> 8 -> null
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);

        System.out.print("Original List: ");
        printList(head);

        // Reverse Iteratively
        head = reverseListIterative(head);
        System.out.print("Reversed (Iterative): ");
        printList(head);

        // Reverse Recursively
        head = reverseListRecursive(head);
        System.out.print("Reversed Again (Recursive): ");
        printList(head);
    }

    // ================= Iterative Approach =================
    // Time: O(n), Space: O(1)
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next
            curr.next = prev; // reverse link
            prev = curr; // move prev
            curr = nextNode; // move curr
        }
        return prev; // new head
    }

    // ================= Recursive Approach =================
    // Time: O(n), Space: O(n) (call stack)
    public static ListNode reverseListRecursive(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);

        head.next.next = head; // reverse
        head.next = null; // break old link

        return newHead;
    }

    // ================= Utility =================
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // ================= ListNode =================
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
