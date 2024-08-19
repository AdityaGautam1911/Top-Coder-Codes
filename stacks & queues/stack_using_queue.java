import java.util.*;
public class stack_using_queue {
    public static Queue<Integer> q1=new ArrayDeque<>();
    public static Queue<Integer> q2=new ArrayDeque<>();

    public static void push(int num){
        if(q1.isEmpty()){
            q1.add(num);
            System.out.println(num+" added");
        }
        else{
            while(!q1.isEmpty()){
                q2.add(q1.peek());
                q1.remove();
            }
            q1.add(num);
            System.out.println(num+" added");
            while(!q2.isEmpty()){
                q1.add(q2.peek());
                q2.remove();
            }
        }
    }
    public static void pop(){
        System.out.println(q1.peek()+" removed");
        q1.remove();
    }
    public static void main(String[] args){
        push(1);
        push(2);
        push(3);
        pop();
        push(4);
        push(5);
        pop();

        while(!q1.isEmpty()){

            System.out.print(q1.peek()+" ");
            q1.remove();
        }
    }
}
