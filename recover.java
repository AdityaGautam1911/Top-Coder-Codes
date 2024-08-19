public class recover {
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

    public static void main(String[] args) {

        Node root = new Node(8);
        root.L = new Node(12);
        root.R = new Node(4);
        root.L.L = new Node(1);
        root.L.R = new Node(5);
        root.R.L = new Node(10);
        root.R.R = new Node(13);
        PrintTree(root);
        System.out.println();
        CrctTreeNode(root);
        Swap();
        PrintTree(root);
    }
}