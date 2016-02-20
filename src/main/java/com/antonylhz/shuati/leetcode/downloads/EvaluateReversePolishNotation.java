public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(String str : tokens) {
            int num1=0, num2=0;
            if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) {
                if(s.isEmpty()) return Integer.MIN_VALUE;
                else num2 = s.pop();
                if(s.isEmpty()) return Integer.MIN_VALUE;
                else num1 = s.pop();
            }
            if(str.equals("+")) s.push(num1+num2);
            else if(str.equals("-")) s.push(num1-num2);
            else if(str.equals("*")) s.push(num1*num2);
            else if(str.equals("/")) s.push(num1/num2);
            else s.push(Integer.parseInt(str));
        }
        return s.pop();
    }
}