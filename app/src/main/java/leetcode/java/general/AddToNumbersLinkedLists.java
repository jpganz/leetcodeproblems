package leetcode.java.general;


/*
https://leetcode.com/problems/add-two-numbers/description/

 */

public class AddToNumbersLinkedLists {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode emptyNode = new ListNode(0);
        ListNode summatory = new ListNode();

        int sum = l1.val + l2.val;
        if (sum > 9) {
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val++;
                if(l2.next == null) {
                    l2.next = emptyNode;
                }
            }
            summatory.val = sum % 10;
        } else {
            summatory.val = sum;
        }

        if (l1.next == null && l2.next == null) {
            return summatory;
        } else if (l1.next == null) {
            summatory.next = l2.next;
            return summatory;
        } else if (l2.next == null) {
            summatory.next = l1.next;
            return summatory;
        }
        summatory.next = addTwoNumbers(l1.next, l2.next);
        return summatory;
}


    // 9 - 9 - 9 - 9
    // 9 - 9
    // 8 - 9 - 10

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(9);
        ListNode nodeA2 = new ListNode(9);
        ListNode nodeA3 = new ListNode(9);
        ListNode nodeA4 = new ListNode(9);
        ListNode nodeA5 = new ListNode(9);
        ListNode nodeA6 = new ListNode(9);
        ListNode nodeA7 = new ListNode(9);

        ListNode nodeB1 = new ListNode(9);
        ListNode nodeB2 = new ListNode(9);
        ListNode nodeB3 = new ListNode(9);
        ListNode nodeB4 = new ListNode(9);
        ListNode nodeB5 = new ListNode(9);
        ListNode nodeB6 = new ListNode(9);
        ListNode nodeB7 = new ListNode(9);

        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        //nodeA4.next = nodeA5;
//        nodeA5.next = nodeA6;
//        nodeA6.next = nodeA7;

        nodeB1.next = nodeB2;
        //nodeB2.next = nodeB3;
        //nodeB3.next = nodeB4;
//        nodeB4.next = nodeB5;
//        nodeB5.next = nodeB6;
//        nodeB6.next = nodeB7;

        //decodeString(input);
        int top = 0;
        ListNode merged = addTwoNumbers(nodeA1, nodeB1);
        while(merged.next != null) {
            System.out.println(merged.val);
            merged = merged.next;
            top++;
            if(top > 20) break;
        }
        System.out.println(merged.val);
    }
}

