package leetcode.java.general;


/*
https://leetcode.com/problems/merge-two-sorted-lists/description/ */

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head;
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val < list2.val) {
                head = list1;
                head.next = mergeTwoLists(list1.next, list2);
                return head;
            } else {
                head = list2;
                head.next = mergeTwoLists(list1, list2.next);
                return head;
            }
        }
    }



    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(4);

        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(3);
        ListNode nodeB3 = new ListNode(4);

        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        //decodeString(input);
        ListNode merged = mergeTwoLists(nodeA1, nodeB1);
        while(merged.next != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }

        boolean isThereANext = true;



    }
}

