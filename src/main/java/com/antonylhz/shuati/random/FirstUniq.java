package com.antonylhz.shuati.random;

import java.util.*;

public class FirstUniq {
	public static void main(String[] args) {
		char[] arr = new char[] {
			'a', 'b', 'a', 'c', 'b'
		};
		System.out.println(findFirstUniq(arr));
	}
	
	private static char findFirstUniq(char[] arr) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : arr) {
			map.put(c, map.containsKey(c)?
					map.get(c)+1:1);
		}
		for(char c : arr) {
			if(map.get(c)==1) {
				return c;
			}
		}
		return '\0';
	}
}
