package exprEvaluation;
import java.util.Stack;

public class Tester {

    public static int calculate(int op1, char opr, int op2) {
        switch(opr) {
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '/': return op1 / op2;
            case '*': return op1 * op2;
            case '%': return op1 % op2;
            case '$': return (int)Math.pow(op1, op2);
        }
        return 0;
    }

    private static boolean isOperator(String token) {
        if (token.length() != 1)     
            return false;
        char c = token.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '$';
    }

    public static int postfixEvaluate(String postfix) {
        Stack<Integer> st = new Stack<>();

        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                char op = token.charAt(0);
                int op2 = st.pop();
                int op1 = st.pop();
                int res = calculate(op1, op, op2);
                st.push(res);
            }
            else {
                int value = Integer.parseInt(token);   
                st.push(value);
            }
        }

        return st.isEmpty() ? 0 : st.pop();
    }

    public static int prefixEvaluate(String prefix) {
        Stack<Integer> st = new Stack<>();

        String[] tokens = prefix.trim().split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                char op = token.charAt(0);
                int op1 = st.pop();
                int op2 = st.pop();
                int res = calculate(op1, op, op2);
                st.push(res);
            } else {
                int value = Integer.parseInt(token);
                st.push(value);
            }
        }

        return st.isEmpty() ? 0 : st.pop();
    }

    public static void main(String[] args) {

        String postfix = "12 3 4 * + 10 -";
        System.out.println("Postfix : " + postfix);
        int result = postfixEvaluate(postfix);
        System.out.println("Postfix Result : " + result);

        String prefix = "- + 12 * 3 4 10";
        System.out.println("Prefix : " + prefix);
        result = prefixEvaluate(prefix);
        System.out.println("Prefix Result : " + result);
    }
}


