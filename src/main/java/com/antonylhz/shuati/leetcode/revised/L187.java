package com.antonylhz.shuati.leetcode.revised;

//Repeated DNA Sequences
//
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        List<String> result = new ArrayList<String>();
        if(s==null||s.length()<=10) return result;
        int hash = 0;
        for(int i=0; i<10; i++) hash = updateHash(hash, s.charAt(i));
        map.put(hash, false);
        for(int i=10; i<s.length(); i++) {
            hash = updateHash(hash, s.charAt(i));
            if(map.containsKey(hash)&&!map.get(hash)) {
                result.add(s.substring(i-9, i+1));
                map.put(hash, true);
            }
            else map.put(hash, false);
        }
        return result;
    }
    
    private int updateHash(int hash, char c) {
        hash <<= 2;
        switch(c) {
            case 'C':
                hash += 1;
                break;
            case 'T':
                hash += 2;
                break;
            case 'G':
                hash += 3;
                break;
        }
        return hash;
    }
}
