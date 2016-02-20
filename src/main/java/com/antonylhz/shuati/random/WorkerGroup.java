package com.antonylhz.shuati.random;

/**
 * 
 * @author antonylhz
 * 
 * Problem: Given required skills, and some workers who master a subset of those skills,
 * 			find the group of workers that satisfy all the requirements with the minimum size.
 * 
 *
 */

import java.util.*;

public class WorkerGroup {
	
	public static void main(String[] args) {
		String[] required = new String[] {
				"Java", "R", "Go"
		};
		String[][] workers = new String[][] {
			new String[]{"Java"},
			new String[]{"R"},
			new String[]{"Java", "Go"}
		};
		System.out.println(findGroup(required, workers));
	}

	private static int findGroup(String[] required, String[][] workers) {
		HashMap<String, Integer> smap = new HashMap<>();
		for(int i=0; i<required.length; i++) {
			smap.put(required[i], i);
		}
		int target = (1 << required.length) - 1;
		List<Integer> singles = new ArrayList<>();
		for(int i=0; i<workers.length; i++) {
			int mask = 0;
			for(String s : workers[i]) {
				if(smap.containsKey(s)) {
					mask += 1 << smap.get(s);
				}
			}
			if(mask>0) {
				singles.add(mask);
			}
		}
		int cnt = 1;
		LinkedList<Integer> groups = new LinkedList<>();
		groups.add(0);
		for(; cnt<=singles.size(); cnt++) {
			int curSize = groups.size();
			for(int i=0; i<curSize; i++) {
				int group = groups.removeFirst();
				for(int single : singles) {
					int newGroup = single | group;
					if(newGroup == target) {
						return cnt;
					} else {
						groups.add(newGroup);
					}
				}
			}
		}
		return cnt;
	}

}
