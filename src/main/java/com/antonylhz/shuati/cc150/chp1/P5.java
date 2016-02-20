package com.antonylhz.shuati.cc150.chp1;

/* Write a method to replace all spaces in a string with ‘%20’.
 * 
 */

import java.util.*;

public class P5 {
	public static void main(String[] args) {
		System.out.println(replace("c://Program files".toCharArray()));
	}
	
	private static String replace(char[] s) {
		StringBuilder r = new StringBuilder();
		for(char c : s) {
			if(c==' ') {
				r.append("%20");
			} else {
				r.append(c);
			}
		}
		return r.toString();
	}
}
