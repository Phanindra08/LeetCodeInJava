/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode middleNodeInList = head;
        ListNode fastPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            middleNodeInList = middleNodeInList.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode secondListHead = middleNodeInList.next;
        middleNodeInList.next = null;

        secondListHead = reverseList(secondListHead);

        ListNode firstListHead = head;
        ListNode nextNodeFromList1, nextNodeFromList2;
        while(firstListHead != null && secondListHead != null) {
            nextNodeFromList1 = firstListHead.next;
            nextNodeFromList2 = secondListHead.next;
            firstListHead.next = secondListHead;
            secondListHead.next = nextNodeFromList1;
            firstListHead = nextNodeFromList1;
            secondListHead = nextNodeFromList2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
