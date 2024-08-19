import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class views {
    static class Node {
        int data;
        Node L = null, R = null;

        Node(int d) {
            data = d;
        }
    }

    static void PrintTree(Node cnt) {
        if (cnt == null)
            return;

        PrintTree(cnt.L);
        System.out.print(cnt.data + " ");
        PrintTree(cnt.R);
    }

    static Node Fir = null, pre = null, end = null, mid = null;

    static void CrctTreeNode(Node crnt) {
        if (crnt == null)
            return;

        CrctTreeNode(crnt.L);

        if (pre != null && crnt.data < pre.data) {
            if (Fir == null) {
                Fir = pre;
                mid = crnt;
            } else
                end = crnt;
        }
        pre = crnt;

        CrctTreeNode(crnt.R);
    }

    static void Swap() {

        if (Fir != null && end != null) {
            int t = Fir.data;
            Fir.data = end.data;
            end.data = t;
        } else if (Fir != null && mid != null) {
            int t = Fir.data;
            Fir.data = mid.data;
            mid.data = t;
        }
    }

    public static void buildTree(ArrayList<Integer> arr) {
        root = new Node(arr.get(0));
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (i < arr.size()) {
            Node curr = q.peek();
            q.remove();
            Node leftNode = new Node(arr.get(i));
            i++;
            if (leftNode != null) {
                curr.left = leftNode;
                q.add(leftNode);
            }
            if (i < arr.size()) {
                Node rightNode = new Node(arr.get(i));
                i++;
                if (rightNode != null) {
                    curr.right = rightNode;
                    q.add(rightNode);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            arr.add(a);
        }
        buildTree(arr);

        PrintTree(root);
        System.out.println();
        CrctTreeNode(root);
        Swap();
        PrintTree(root);
    }
}