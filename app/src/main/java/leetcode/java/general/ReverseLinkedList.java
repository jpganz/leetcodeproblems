package leetcode.java.general;


/*
https://leetcode.com/problems/add-two-numbers/description/

 */

public class ReverseLinkedList {


    // multiple ways of doing it
    // store all items in an array
    // loop the array from last to first moving the references
    // store head as last item of array
    // return head

    // another way might be
    // 1 - 2 - 3 - 4 - 5
    // store previous reference and current and next
    // if previous is not null, store next = n.next reference (now Im in 2, I store the reference to node3)
    // update n.next = previous
    // set previous to n
    // loop continues from the next
    // 1 - previous is null, 1.next is 2, current.next = null, previous = current
    // 2 - previous is 1, 2.next is 3, counter = 2.next, 2.next = previous,
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current  = head;
        ListNode previous = null;
        ListNode temporal = null;
        ListNode lastHead = null;
        while(current != null) { // time o(n)  -- space n
            lastHead = current;
            temporal = current.next;
            if(previous == null) {
                current.next = null;
            } else {
                temporal = current.next;
                current.next = previous;
            }
            previous = current;
            current = temporal;
        }
        return lastHead;
    }


    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(3);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);


        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        ListNode result = reverseList(nodeA1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

