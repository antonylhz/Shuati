package com.antonylhz.shuati.cc150.chp1;

public class P8 {
	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "bottlewater"));
	}
	
	private static boolean isRotation(String s1, String s2) {
		return isSubstring(s1, s2+s2);
	}
	
	private static boolean isSubstring(String s1, String s2) {
		return s2.contains(s1);
	}
}
