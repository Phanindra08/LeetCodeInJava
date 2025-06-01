package edu.charlotte.data_structures.linked_list;

public class MergeTwoSortedLists {

    /**
     * This method takes the heads of two sorted linked lists as input, merge both the singly-linked lists into a single sorted linked list and returns the head of a new sorted list that contains all the nodes from the input lists.
     * We are creating a dummy node to simplify the process of building the new list.
     * We are maintaining a tail pointer to track the current end of the merged list.
     * The nodes from the input lists are reused directly without creating new nodes.
     *
     * @param list1 - The head of the first sorted singly-linked list.
     * @param list2 - The head of the second sorted singly-linked list.
     * @return - The head of the merged sorted singly-linked list.
     */
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
        if(list2 != null)
            tail.next = list2;
        return dummy.next;
    }

    /**
     * Iterates through the input array and creates a linked list where each element of the array corresponds to a node in the list. We are creating a dummy node to simplify the process of building the new list.
     * @param arrayInput - The array of integers to be converted into a singly-linked list.
     * @return - The head node of the newly created singly-linked list.
     */
    private ListNode createList(int[] arrayInput) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for(int input: arrayInput) {
            tail.next = new ListNode(input, null);
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * Traverse through the Singly-linked list and prints all the values in the linked list.
     * @param outputList - The head node of the singly-linked list.
     */
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

    /**
     * Demonstrates sample test cases from Leetcode by creating singly-linked lists using the {@code create} method.
     * The two generated list nodes are then passed as input to the {@code mergeTwoLists} method for merging.
     * @param args - Command line arguments (not used)
     */
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1 = mergeTwoSortedLists.createList(new int[]{1, 2, 4});
        ListNode list2 = mergeTwoSortedLists.createList(new int[]{1, 3, 4});
        mergeTwoSortedLists.print(mergeTwoSortedLists.mergeTwoLists(list1, list2));
        mergeTwoSortedLists.print(mergeTwoSortedLists.mergeTwoLists(null, null));
        list2 = mergeTwoSortedLists.createList(new int[]{0});
        mergeTwoSortedLists.print(mergeTwoSortedLists.mergeTwoLists(null, list2));
    }

    /**
     * Definition for singly-linked list.
     * Created a default constructor, a constructor with one argument, a constructor with two arguments.
     */
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
