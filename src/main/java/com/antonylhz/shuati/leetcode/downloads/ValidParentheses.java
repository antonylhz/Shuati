public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length()==0) return true;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{') stack.push(c);
            else if(stack.isEmpty()||!isMatch(c, stack.pop())) return false;
        }
        return stack.isEmpty();
    }
    private boolean isMatch(char c, char top){
        switch(c) {
            case ')':
                return top=='(';
            case ']':
                return top=='[';
            case '}':
                return top=='{';
            default:
                return false;
        }
    }
}