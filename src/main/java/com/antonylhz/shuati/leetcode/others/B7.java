package com.antonylhz.shuati.leetcode.others;

public class B7 {
	public static void main(String[] args) {
		B7 solution = new B7();
		char[] str1 = "a".toCharArray();
		solution.reverseWords(str1);
		System.out.println(str1);
		char[] str2 = "a  bc".toCharArray();
		solution.reverseWords(str2);
		System.out.println(str2);
	}
	
	public void reverseWords(char[] chars) {
		reverseSubstring(chars, 0, chars.length-1);
		for(int i=0, j=0; j<=chars.length; j++) {
			if(j==chars.length||chars[j]==' ') {
				reverseSubstring(chars, i, j-1);
				if(j<chars.length){
					while(j<chars.length&&chars[j]==' ') j++;
					i = j;
				}
			}
		}
	}
	
	/*
	 * reverse the substring of a certain string, starting from start to end, inclusive.
	 */
	public void reverseSubstring(char[] chars, int start, int end) {
		while(start<end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
}



