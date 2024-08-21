package leetcode.java.general;


import java.util.Stack;
/*
https://leetcode.com/problems/decode-string/description/


 */
public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        // an easy way is to find how many linked nodes are by looping them all
        // then loop them again and get the node we want to remove it and update the next value
        int length = 1;
        while(current.next != null) {
            length++;
            current = current.next;
        }
        // now that we know length, we find n-1 and update it to point to n+1
        // special case: when n is first or last

        int nodeToRemove = (length - n ) + 1;

        // if we want to remove first item
         if (nodeToRemove == 1) {
            return head.next;
        }
        current = head;

        for(int i = 1; i < nodeToRemove -1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode response = removeNthFromEnd(node1, 2);
        System.out.println("responses " + response);
        while(response != null && response.next != null) {

            System.out.println(response.val);
            response = response.next;
        }
        System.out.println(response.val);


    }
}
