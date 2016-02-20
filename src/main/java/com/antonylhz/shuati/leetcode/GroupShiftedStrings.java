package com.antonylhz.shuati.leetcode;
import java.util.*;

public class GroupShiftedStrings {

    private List<List<String>> groups;

    public static void main(String[] args) {
        String[] strs = new String[] {
            "abc", "bcd", "yza", "a", "z"
        };
        GroupShiftedStrings groups = new GroupShiftedStrings(strs);
        System.out.println(groups.toString());
    }

    public GroupShiftedStrings(String[] strs) {
        this.groups = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for(String s : strs) {
            int[] diff = new int[s.length()-1];
            for(int i=1; i<s.length(); i++) {
                diff[i-1] = (s.charAt(i) - s.charAt(i-1)+26) % 26;
            }
            int hc = arrayHashcode(diff);
            if(!map.containsKey(hc)) {
                map.put(hc, new ArrayList<>());
            }
            map.get(hc).add(s);
        }
        for(List<String> g : map.values()) {
            Collections.sort(g);
            this.groups.add(g);
        }
    }

    // might overflow
    private int arrayHashcode(int[] diff) {
        int res = 0;
        for(int d : diff) {
            res *= 26;
            res += d;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(List<String> g : groups) {
            for(String s : g) {
                res.append(s).append("  ");
            }
            res.append("\n");
        }
        return res.toString();
    }

}
