package linkedlist;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseLinkedList {
    public ListNode createLinkedList() {
        ListNode listNode8 = new ListNode(8);
        ListNode listNode2 = new ListNode(2, listNode8);
        ListNode listNode4 = new ListNode(4, listNode2);
        ListNode listNode1 = new ListNode(1, listNode4);
        ListNode listNode3 = new ListNode(3, listNode1);
        ListNode listNode7 = new ListNode(7, listNode3);
        ListNode listNode6 = new ListNode(6, listNode7);
        ListNode headNode = new ListNode(5, listNode6);

        return headNode;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previousNode = head;
        ListNode currentNode = head.next;
        ListNode nextNode;

        head.next = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode headNode = reverseLinkedList.createLinkedList();
        headNode.print();
        ListNode reversedNode = reverseLinkedList.reverseList(headNode);
        System.out.println();
        reversedNode.print();


        List<Integer> brightness = List.of(1, 2, 3 , 4);
        Collections.sort(brightness);


    }
}
