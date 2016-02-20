package com.antonylhz.shuati.leetcode;
import java.util.*;

public class B12 {
	public static void main(String[] args) {
		B12 solution = new B12();
		int[] vals = new int[] {
			2,3,4,5,12,45,56,98
		};
		System.out.println(solution.findMissingRanges(vals, 1, 99));
		int[] vals2 = new int[] {
				
			};
		System.out.println(solution.findMissingRanges(vals2, 1, 99));
	}
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList<String>();
		int prev = start - 1;
		for(int i=0; i<=vals.length; i++) {
			int current = (i==vals.length?end+1:vals[i]);
			if(current-prev==2) ranges.add(String.valueOf(prev+1));
			else if(current-prev>2) ranges.add(String.valueOf(prev+1)+"=>"+String.valueOf(current-1));
			prev = current;
		}
		return ranges;
	}
}
