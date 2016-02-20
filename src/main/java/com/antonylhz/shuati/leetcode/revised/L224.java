package com.antonylhz.shuati.leetcode.revised;

import java.util.Stack;

public class L224 {

    private Stack<String> stack = new Stack<String>();

    public static void main(String[] args) {
        L224 calc = new L224();
    	System.out.println(calc.calculate("((4+90))"));
    }
    
    private int evaluate(boolean isEnd) {
        int result = 0, number = 0;
        while(!stack.isEmpty()) {
            String temp = stack.pop();
            if(temp.equals("+")) {
                result += number;
                number = 0;
            } else if(temp.equals("-")) {
                result -= number;
                number = 0;
            } else if(temp.equals("(")) {
            	if(number>0) result += number;
            	if(!isEnd) {
            		stack.push(String.valueOf(result));
            		return result;
            	}
            } else number = Integer.parseInt(temp);
        }
        return number+result;
    }
    
    private int calculate(String s) {
        char[] chars = s.toCharArray();
        int number = 0;
        for(int i=0; i<s.length(); i++) {
            if(chars[i]>='0'&&chars[i]<='9') {
                number *= 10;
                number += Integer.parseInt(""+chars[i]);
            } else {
                if(number>0) {
                    stack.push(String.valueOf(number));
                    number = 0;
                }
                if(chars[i]==')') evaluate(false);
                else if(chars[i]!=' ') stack.push(""+chars[i]);
            }
        }
        if(number>0) stack.push(String.valueOf(number));
        return evaluate(true);
    }
    
}
