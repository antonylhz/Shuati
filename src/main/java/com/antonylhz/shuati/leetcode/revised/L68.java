package com.antonylhz.shuati.leetcode.revised;

//Text Justification 
//
//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is inserted between words.
//
//For example,
//words: ["This", "is", "an", "example", "of", "text", "justification."]
//L: 16.
//
//Return the formatted lines as:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//Note: Each word is guaranteed not to exceed L in length.

import java.util.ArrayList;
import java.util.List;

public class L68 {
	public static void main(String[] args) {
		String[] words = new String[]{
				"What","must","be","shall","be."};
		L68 solution = new L68();
		List<String> result = solution.fullJustify(words, 12);
		for(String str : result) System.out.println(str);
	}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int wordlen = 0, start = 0;
        for(int i=0; i<words.length; i++) {
            if(words[i].length() + wordlen + i-start > maxWidth) {
                result.add(buildLine(words, start, i-start, wordlen, maxWidth, false));
                wordlen = 0; start = i;
            }
            wordlen += words[i].length();
        }
        result.add(buildLine(words, start, words.length-start, wordlen, maxWidth, true));
        return result;
    }
    private String buildLine(String[] words, int start, int word, int wordlen, int maxWidth, boolean last) {
        StringBuilder sb = new StringBuilder();
        if(word==1) {
            sb.append(words[start]);
            while(sb.length()<maxWidth) sb.append(" ");
        } else if(last) {
        	for(int i=0; i<word-1; i++) {
        		sb.append(words[start+i]);
        		sb.append(" ");
        	}
        	sb.append(words[start+word-1]);
            while(sb.length()<maxWidth) sb.append(" ");
        } else {
            int space_len = (maxWidth - wordlen) / (word-1);
            int left_extra = maxWidth - wordlen - space_len * (word-1);
            for(int j=0; j<word-1; j++) {
                sb.append(words[start+j]);
                for(int k=0; k<space_len; k++) sb.append(" ");
                if(left_extra>0) {
                    sb.append(" ");
                    left_extra--;
                }
            }
            sb.append(words[start+word-1]);
        }
        return sb.toString();
    }
}
