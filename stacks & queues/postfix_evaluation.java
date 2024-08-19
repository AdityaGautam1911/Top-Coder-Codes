import java.util.*;
public class postfix_evaluation {
    public static double evaluate(String s){
        StringBuilder sb=new StringBuilder(s);
        StringBuilder curr=new StringBuilder();
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(Character.isDigit(c)){
                st.push(c-'0');
            }
            if(c==' '){
                continue;
            }
            else{
                
                int b=st.pop();
                int a=st.pop();
                if(c=='+'){
                    st.push(a+b);
                }
                if(c=='-'){
                    st.push(a-b);
                }
                if(c=='*'){
                    st.push(a*b);
                }
                if(c=='/'){
                    st.push(a/b);
                }
            }
        }
        return st.peek();
    }
    public static void main(String[] args){
        // String s="100 200 + 2 / 5 * 7 +";
        String s="38+98/-";
        System.out.println(evaluate(s));
    }
}
