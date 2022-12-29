import java.util.*;

// convert infix expression to postfix expression

public class Postfix {
    public static void postfix(String exp) {
        StringBuilder res = new StringBuilder();
        Stack<Character> ops = new Stack<Character>();
        Set<Character> ref = new HashSet<Character>(Arrays.asList('+', '-', '*', '/', '%'));
        char c;
        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            if (c == ' ') {
            } else if (ref.contains(c)) {
                while (!ops.empty() && prec(ops.peek()) >= prec(c)) {
                    res.append(ops.pop());
                }
                ops.push(c);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    res.append(ops.pop());
                }
                ops.pop();
            } else { // is a character.
                res.append(c);
            }
        }
        while (!ops.empty()) {
            res.append(ops.pop());
        }
        System.out.println(res);
    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0; // ( will return zero
    }

    public static void main(String[] args) {
        postfix("A * B /  (C * D + G) * E / F");
    }
}
