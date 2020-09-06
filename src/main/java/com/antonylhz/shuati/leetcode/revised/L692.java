package com.antonylhz.shuati.leetcode.revised;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L692 {

    public static void main(String[] args) {
        String[] words = new String[] {
                "i", "love", "leetcode", "i", "love", "coding"
        };
        List<String> res = new Solution().topKFrequent(words, 2);
        System.out.println(res);
    }

}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cntMap = new HashMap<>();
        List<String> distinct = new LinkedList<>();
        for (String word : words) {
            if (!cntMap.containsKey(word)) {
                distinct.add(word);
            }
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }
        distinct.sort((w1, w2) -> {
            int cntDiff = cntMap.get(w2) - cntMap.get(w1);
            if (cntDiff != 0) return cntDiff;
            return w1.compareTo(w2);
        });
        return distinct.subList(0, Math.min(k, distinct.size()));
    }
}