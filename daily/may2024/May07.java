package daily.may2024;


import java.util.Stack;

public class May07 {
    public static void main(String[] args) {
        ListNode head = createLinkedList();
        ListNode doubleItNode = doubleIt(head);
        traverseLinkedList(doubleItNode);
    }

    private static ListNode doubleIt(ListNode head) {
        Stack<ListNode> st = new Stack();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp = temp.next;
        }
        ListNode reqNode = null;
        int carry = 0;
        while(st.size()>0){
            int top = ((st.pop().val)*2+carry);
            int actNode = top%10;
            carry = top/10;
            ListNode localTemp = new ListNode(actNode);
            localTemp.next = reqNode;
            reqNode = localTemp;
        }
        if(carry>0){
            ListNode carryNode = new ListNode(carry);
            carryNode.next = reqNode;
            reqNode = carryNode;
        }
        return reqNode;
    }

    private static void traverseLinkedList(ListNode head) {
        ListNode temp = head;
        int i=1;
        while (temp != null) {
            System.out.println(STR."Element No'\{i} : \{temp.val}");
            i++;
            temp = temp.next;
        }
    }

    private static ListNode createLinkedList() {

        ListNode node1 = new ListNode(1);
        ListNode.head = node1;
        ListNode node2 = new ListNode(8);
        node1.next=node2;
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        return ListNode.head;

    }


    public static class  ListNode{
        int val;
        ListNode next;
        static ListNode head = null;
        static int size = 0;
        ListNode(int val){
            this.val = val;
            this.next = null;
            this.size++;
        }
        ListNode(){

        }

    }
}
