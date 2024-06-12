package daily.LinkedList;

public class ReverseListInGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        reverseKGroup(head, 0);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        // If the list is empty or has only one node, or k is 1, return the head as is
        if (head == null || head.next == null || k == 1) return head;

        // Dummy node initialization
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Find the kth node from groupPrev
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next;
            }

            // Reverse k nodes
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Update pointers
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

    }

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
