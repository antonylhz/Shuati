package com.antonylhz.shuati.leetcode.others;

import java.util.Stack;
public class LongestParentheses {
	public static void main(String[] args) {
		LongestParentheses solution = new LongestParentheses();
		System.out.println(solution.longestValidParentheses("(()()"));
	}
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty()&&s.charAt(i)==')'&&s.charAt(stack.peek())=='(') {
                stack.pop();
                max = Math.max(max, i-(stack.isEmpty()?-1:stack.peek()));
            } else stack.push(i);
        }
        return max;
    }
}
