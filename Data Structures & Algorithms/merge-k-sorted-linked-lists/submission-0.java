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
        
        List<ListNode> nodeLists = new ArrayList<>();
        for(ListNode node: lists)
            nodeLists.add(node);
        while(nodeLists.size() > 1) {
            int mid = nodeLists.size() / 2;
            ListNode node = mergeTwoLists(nodeLists.get(mid - 1), nodeLists.get(mid));
            nodeLists.set(mid - 1, node);
            nodeLists.remove(mid);
        }
        return nodeLists.get(0);
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
