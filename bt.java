import java.util.*;

public class bt {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node root = null;

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

    public static void display() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.peek();
                q.remove();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
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
        display();
    }
}
