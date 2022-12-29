import java.util.*;

// convert infix expression to prefix expression
// reverse the exp, do a postfix on it
// reverse the result.

public class Prefix {

    public static void prefix(String exp) {
        StringBuffer reverse = new StringBuffer();
        char c;
        for (int i = exp.length() - 1; i >= 0; i--) {
            c = exp.charAt(i);
            if (c == '(') {
                reverse.append(')');
            } else if (c == ')') {
                reverse.append('(');
            } else {
                reverse.append(c);
            }
        }
        exp = reverse.toString();
        Stack<Character> res = new Stack<Character>();
        Stack<Character> ops = new Stack<Character>();
        Set<Character> ref = new HashSet<Character>(Arrays.asList('+', '-', '*', '/', '%'));
        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            if (c == ' ') {
            } else if (ref.contains(c)) {
                while (!ops.empty() && prec(ops.peek()) >= prec(c)) {
                    res.push(ops.pop());
                }
                ops.push(c);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    res.push(ops.pop());
                }
                ops.pop();
            } else { // is a character.
                res.push(c);
            }
        }
        while (!ops.empty()) {
            res.push(ops.pop());
        }
        while (!res.empty()) {
            System.out.print(res.pop());
        }

    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0; // ( will return zero
    }

    public static void main(String[] args) {
        prefix("A * B / (C * D + G) * E / F");
    }
}
