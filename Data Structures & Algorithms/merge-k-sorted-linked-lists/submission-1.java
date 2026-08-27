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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        while (lists.length > 1) {
            List<ListNode> newMergedLists = new ArrayList<>();
            for(int index = 0; index < lists.length; index = index + 2) {
                ListNode node1 = lists[index];
                ListNode node2 = (index + 1 < lists.length) ? lists[index + 1] : null;
                newMergedLists.add(mergeTwoLists(node1, node2));
            }
            lists = newMergedLists.toArray(ListNode[]::new);
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode currentNode = dummy;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                currentNode.next = node1;
                node1 = node1.next;
            } else {
                currentNode.next = node2;
                node2 = node2.next;
            }
            currentNode = currentNode.next;
        }
        if(node1 != null)
            currentNode.next = node1;
        else
            currentNode.next = node2;
        return dummy.next;
    }
}
