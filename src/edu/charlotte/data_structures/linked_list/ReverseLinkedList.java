package edu.charlotte.data_structures.linked_list;

public class ReverseLinkedList {
    private ListNode reverseListSolution1(ListNode head) {
        if(head == null)
            return null;
        ListNode newHead = head;
        if(head.next != null) {
            newHead = reverseListSolution1(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    private ListNode reverseListSolution2(ListNode head) {
        ListNode prev = null;
        ListNode duplicate;
        while(head != null) {
            duplicate = head.next;
            head.next = prev;
            prev = head;
            head = duplicate;
        }
        return prev;
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
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode list1 = reverseLinkedList.createList(new int[] {1, 2, 3, 4, 5});
        reverseLinkedList.print(reverseLinkedList.reverseListSolution1(list1));
        list1 = reverseLinkedList.createList(new int[] {1, 2});
        reverseLinkedList.print(reverseLinkedList.reverseListSolution2(list1));
        list1 = reverseLinkedList.createList(new int[] {});
        reverseLinkedList.print(reverseLinkedList.reverseListSolution1(list1));
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
