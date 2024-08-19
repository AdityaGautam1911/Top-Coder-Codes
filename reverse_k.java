import java.util.*;
import java.lang.*;
import java.io.*;

class reverse_k {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head = null;

    public void addNode(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = head;
        int count = 0;

        while (end != null) {
            count++;
            if (count % k == 0) {
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode first = curr;
        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws java.lang.Exception {
        reverse_k sList = new reverse_k();
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String[] numbersStr = input.split("\\s+");
        for (String numStr : numbersStr) {
            int num = Integer.parseInt(numStr);
            sList.addNode(num);
        }
        int k = scn.nextInt();
        ListNode result = reverseKGroup(sList.head, k);
        printList(result);
    }
}