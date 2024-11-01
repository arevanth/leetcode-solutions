package linkedlist;

public class ListNode {
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

    void print() {
        ListNode currentNode = this;

        while (currentNode != null) {
            System.out.printf("%s --> ", currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }
}
