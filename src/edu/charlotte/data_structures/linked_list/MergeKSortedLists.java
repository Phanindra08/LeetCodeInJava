package edu.charlotte.data_structures.linked_list;


public class MergeKSortedLists {

    private ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        ListNode[] newMergedList;
        int newMergedListIndex;
        while(lists.length > 1) {
            newMergedList = new ListNode[(lists.length + 1) / 2];
            newMergedListIndex = 0;
            for(int index = 0; index < lists.length; index += 2) {
                ListNode list1 = lists[index];
                ListNode list2 = (index + 1 < lists.length) ? lists[index + 1] : null;
                newMergedList[newMergedListIndex] = mergeTwoLists(list1, list2);
                newMergedListIndex++;
            }
            lists = newMergedList;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null)
            tail.next = list1;
        else if(list2 != null)
            tail.next = list2;
        return dummy.next;
    }

    private ListNode createList(int[] arrayInput) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for(int input: arrayInput) {
            tail.next = new ListNode(input, null);
            tail = tail.next;
        }
        return dummy.next;
    }

    private void print(ListNode outputList) {
        System.out.print("[");
        while(outputList != null) {
            System.out.print(outputList.val);
            if(outputList.next != null)
                System.out.print(" ");
            outputList = outputList.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode[] list1 = new ListNode[3];
        list1[0] = mergeKSortedLists.createList(new int[]{1, 4, 5});
        list1[1] = mergeKSortedLists.createList(new int[]{1, 3, 4});
        list1[2] = mergeKSortedLists.createList(new int[]{2, 6});
        ListNode result = mergeKSortedLists.mergeKLists(list1);
        mergeKSortedLists.print(result);
        result = mergeKSortedLists.mergeKLists(new ListNode[0]);
        mergeKSortedLists.print(result);
        list1 = new ListNode[1];
        list1[0] = mergeKSortedLists.createList(new int[0]);
        result = mergeKSortedLists.mergeKLists(list1);
        mergeKSortedLists.print(result);
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
