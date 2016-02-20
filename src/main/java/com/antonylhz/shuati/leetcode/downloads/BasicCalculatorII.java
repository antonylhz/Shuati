public class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        int number = 0;
        boolean reading_number = false;
        boolean exe = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                number *= 10;
                number += Integer.parseInt("" + c);
                reading_number = true;
            } else {
                if (exe) {
                    char op = stack.pop().charAt(0);
                    int num1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(evaluate(num1, number, op)));
                    exe = false;
                } else if (reading_number) stack.push(String.valueOf(number));
                number = 0;
                reading_number = false;
                stack.push("" + c);
                exe = c == '*' || c == '/';
            }
        }
        if (exe) {
            char op = stack.pop().charAt(0);
            int num1 = Integer.parseInt(stack.pop());
            stack.push(String.valueOf(evaluate(num1, number, op)));
            exe = false;
        } else if (reading_number) stack.push(String.valueOf(number));
        int result = 0;
        while (true) {
            if (stack.isEmpty()) return result;
            int num = Integer.parseInt(stack.pop());
            char op;
            if (stack.isEmpty()) op = '+';
            else op = stack.pop().charAt(0);
            result = evaluate(result, num, op);
        }
    }

    private int evaluate(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }
}
