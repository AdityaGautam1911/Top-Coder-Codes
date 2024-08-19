import java.util.*;

public class reorder {
    public static void help(ArrayList<Integer> arr) {
        int i = 0;
        int j = arr.size() - 1;
        while (i <= j) {
            System.out.print(arr.get(i) + " ");
            i++;
            System.out.print(arr.get(j) + " ");
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String ip[] = s.split("\\s+");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < ip.length; i++) {
            int n = Integer.parseInt(ip[i]);
            arr.add(n);
        }
        help(arr);
    }
}
