import java.util.*;

public class infix_to_postfix {
    public static int precedence(char a) {
        if (a == '^') {
            return 1;
        }
        if (a == '*' || a == '/') {
            return 2;
        }
        if (a == '+' || a == '-') {
            return 3;
        } else {
            return -1;
        }
    }

    public static StringBuilder postfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // if operand directly to postfix
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }

            // adding '(' to the stack
            if (c == '(') {
                st.push(c);
            }

            if (c == ')') {
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop(); // remove '('
            }

            if (c == '*' || c == '/' || c == '*' || c == '+' || c == '-' || c == '^') {
                if (st.isEmpty() || precedence(st.peek()) < precedence(c)) {
                    st.add(c);
                } else if (!st.isEmpty() && precedence(st.peek()) >= precedence(c)) {
                    while (!st.isEmpty() && precedence(st.peek()) < precedence(c) ) {
                        sb.append(st.pop());
                    }
                    st.add(c);
                }
            }
        }
        // empty stack and put to result at the end
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // String s = scan.nextLine();
        String s = "a+b*c-d/e";
        System.out.println(postfix(s));
    }
}