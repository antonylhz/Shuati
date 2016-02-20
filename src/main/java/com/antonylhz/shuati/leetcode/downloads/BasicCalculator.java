public class Solution {
    private Stack<String> stack = new Stack<String>();

    private int evaluate(boolean isEnd) {
        int result = 0, number = 0;
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (temp.equals("+")) {
                result += number;
                number = 0;
            } else if (temp.equals("-")) {
                result -= number;
                number = 0;
            } else if (temp.equals("(")) {
                if (number > 0) result += number;
                if (!isEnd) {
                    stack.push(String.valueOf(result));
                    return result;
                }
            } else number = Integer.parseInt(temp);
        }
        return number + result;
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                number *= 10;
                number += Integer.parseInt("" + chars[i]);
            } else {
                if (number > 0) {
                    stack.push(String.valueOf(number));
                    number = 0;
                }
                if (chars[i] == ')') evaluate(false);
                else if (chars[i] != ' ') stack.push("" + chars[i]);
            }
        }
        if (number > 0) stack.push(String.valueOf(number));
        return evaluate(true);
    }
}
