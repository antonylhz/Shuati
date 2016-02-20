package com.antonylhz.shuati.random;

import java.util.*;

public class GameSchedule {
	public static void main(String[] args) {
		getSchedule(5);
	}
	private static void getSchedule(int n) {
		List<Integer> hc = new ArrayList<>();
		
		for(int i=0; i<n; i++) for(int j=i+1; j<n; j++) {
			hc.add(i * n + j);
		}
		Collections.shuffle(hc);
		for(int num : hc) {
			System.out.println(num / n + " v.s. " + num % n);
		}
	}
}
