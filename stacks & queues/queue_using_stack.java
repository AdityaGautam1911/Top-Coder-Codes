import java.util.*;

public class queue_using_stack {
    public static Stack<Integer> s = new Stack<>();
    public static Stack<Integer> s1 = new Stack<>();

    public static void enqueue(Integer num) {
        if (s.isEmpty()) {
            s.push(num);
            System.out.println(num + " added to the queue");
        } else {
            while (!s.isEmpty()) {
                s1.push(s.pop());
            }
            s.push(num);
            System.out.println(num + " added to the queue");
            while (!s1.isEmpty()) {
                s.push(s1.pop());
            }
        }
    }

    public static void dequeue() {
        int a = s.pop();
        System.out.println(a + " removed from queue");
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        dequeue();
        enqueue(4);
        enqueue(5);

        System.out.println("CURRENT QUEUE -->");

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}
