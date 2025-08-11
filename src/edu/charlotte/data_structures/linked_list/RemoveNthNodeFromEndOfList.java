package edu.charlotte.data_structures.linked_list;

public class RemoveNthNodeFromEndOfList {

    private ListNode removeNthFromEndSolution1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode right = head;
        ListNode left = dummy;

        while(n > 0 && right != null) {
            right = right.next;
            n--;
        }

        while(right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    private ListNode removeNthFromEndSolution2(ListNode head, int n) {
        int lengthOfList = 0;
        ListNode dummy = head;
        while(dummy != null) {
            lengthOfList++;
            dummy = dummy.next;
        }
        dummy = head;
        for(int index = 0; index < lengthOfList; index++) {
            if((index + 1) == (lengthOfList - n)) {
                dummy.next = dummy.next.next;
                break;
            } else if(index == (lengthOfList - n)) {
                head = head.next;
                break;
            }
            dummy = dummy.next;
        }
        return head;
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
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode list1 = removeNthNodeFromEndOfList.createList(new int[]{1, 2, 3, 4, 5});
        removeNthNodeFromEndOfList.print(removeNthNodeFromEndOfList.removeNthFromEndSolution1(list1, 2));
        list1 = removeNthNodeFromEndOfList.createList(new int[]{1});
        removeNthNodeFromEndOfList.print(removeNthNodeFromEndOfList.removeNthFromEndSolution2(list1, 1));
        list1 = removeNthNodeFromEndOfList.createList(new int[]{1, 2});
        removeNthNodeFromEndOfList.print(removeNthNodeFromEndOfList.removeNthFromEndSolution1(list1, 1));
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