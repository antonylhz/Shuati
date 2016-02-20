package com.antonylhz.shuati.random;

import java.util.*;

public class StringShuffle {
	public static void main(String[] args) {
		String s = "hello world";
		System.out.println(shuffleDiffSentence(s));
	}
	
	/*
	 * antonylhz Nov 19, 2015
	 * 
	 * Randomly permutes the specified list using a default source of randomness. All permutations occur with approximately equal likelihood.
	 * The hedge "approximately" is used in the foregoing description because default source of randomness is only approximately an unbiased source of independently chosen bits. 
	 * If it were a perfect source of randomly chosen bits, then the algorithm would choose permutations with perfect uniformity.
	 * This implementation traverses the list backwards, 
	 * from the last element up to the second, 
	 * repeatedly swapping a randomly selected element into the "current position". 
	 * Elements are randomly selected from the portion of the list that runs from the first element to the current position, inclusive.

	 * This method runs in linear time. 
	 * If the specified list does not implement the RandomAccess interface and is large, 
	 * this implementation dumps the specified list into an array before shuffling it, 
	 * and dumps the shuffled array back into the list. 
	 * This avoids the quadratic behavior that would result from shuffling a "sequential access" list in place.
	 */
	private static String shuffleAsJavaCollections(String s) {
		char[] c = s.toCharArray();
		Random randomizer = new Random();
		for(int i=c.length-1; i>0; i--) {
			int idx = randomizer.nextInt(i+1);
			if(c[idx]!=c[i]) {
				char temp = c[idx];
				c[idx] = c[i];
				c[i] = temp;
			}
		}
		return String.valueOf(c);
	}
	
	private static String shuffleDiffSentence(String sentence) {
		String[] words = sentence.split(" ");
		int sexit = -1, wexit = -1;
		
		find_exit:
		for(int i=words.length-1; i>=0; i++) {
			char last = words[i].charAt(0);
			for(int j = 1; j<words[i].length(); i++) {
				if(words[i].charAt(j)!=last) {
					sexit = i;
					wexit = j;
					break find_exit;
				}
			}
		}
				
		if(sexit<0) return "";
		boolean diffed = false;
		StringBuilder res = new StringBuilder();
		for(int i=0; i<words.length; i++) {
			if(diffed) {
				res.append(shuffleAsJavaCollections(words[i]));
			} else {
				if(i==sexit) {
					res.append(diffShuffle(words[i]));
					diffed = true;
				} else {
					String shuffled = shuffleAsJavaCollections(words[i]);
					if(!shuffled.equals(words[i])) {
						diffed = true;
					}
					res.append(shuffled);
				}
			}
			res.append(" ");
		}
		return res.toString();
	}
	
	/*
	 * produce a shuffle that is different with the original
	 * 
	 * Idea:
	 * The last chance is when [0...i] are all the same, and i+1 is a different character. 
	 * Swap i+1 with anyone in front
	 */

	private static String diffShuffle(String word) {
		char[] chars = word.toCharArray();
		DiffMap map = new DiffMap();
		for(char c : chars) map.add(c);
		Random randomizer = new Random();
		for(int i=chars.length-1; i>0; i--) {
			int idx = randomizer.nextInt(
					map.isLastChance(chars[i])?i:i+1);
			if(chars[idx]!=chars[i]) {
				char temp = chars[idx];
				chars[idx] = chars[i];
				chars[i] = temp;
				map.remove(chars[idx]);
			} else {
				map.remove(chars[i]);
			}
		}
		return String.valueOf(chars);
	}
	
}

class DiffMap{
	private Map<Character, Integer> map;
	public DiffMap() {
		this.map = new HashMap<Character, Integer>();
	}
	
	public void add(char c) {
		if(map.containsKey(c)) map.put(c, map.get(c));
		else map.put(c, 1);
	}
	
	public void remove(char c) {
		if(map.containsKey(c)&&map.get(c)>1) map.put(c, map.get(c)-1);
		else map.remove(c);
	}
	
	public int size() {
		return map.size();
	}
	
	public boolean isLastChance(char c) {
		return map.containsKey(c)&&map.get(c)==1&&map.size()==2;
	}
	
}
