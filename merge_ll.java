import java.util.*;

public class merge_ll {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node l1 = null;
    public static Node l2 = null;
    public static Node res = null;

    public static Node insert(int a, Node head) {
        Node temp = new Node(a);
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        return head;
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void merge(Node l1, Node l2) {
        Node curr1 = l1;
        Node curr2 = l2;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                res = insert(curr1.data, res);
                curr1 = curr1.next;
            } else {
                res = insert(curr2.data, res);
                curr2 = curr2.next;
            }
        }
        // If there are remaining elements in l1
        while (curr1 != null) {
            res = insert(curr1.data, res);
            curr1 = curr1.next;
        }
        // If there are remaining elements in l2
        while (curr2 != null) {
            res = insert(curr2.data, res);
            curr2 = curr2.next;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        for (int i = 0; i < n1; i++) {
            int a = scan.nextInt();
            l1 = insert(a, l1);
        }
        int n2 = scan.nextInt();
        for (int i = 0; i < n2; i++) {
            int b = scan.nextInt();
            l2 = insert(b, l2);
        }

        merge(l1, l2);
        display(res);
    }
}