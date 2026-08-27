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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int count = 0;
        for(ListNode currentNode = head; currentNode != null; currentNode = currentNode.next)
            count++;
        ListNode currentNode = dummy;
        for(int index = 0; index < (count - n); index++)
            currentNode = currentNode.next;

        currentNode.next = currentNode.next.next;
        return dummy.next;
    }
}
