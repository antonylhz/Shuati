package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class ReverseShuffleMerge {
	public static void main(String[] args) {
		System.out.println(reverseShuffleMerge("bbcbccbabcbabcbaaccccaaabcbcaacacbabbbbcabcbbbbacbcaccccbcccbccaaabcabacccbaccccbbababccbccacbaccacbcccacbaaacacbbcbaaabbabbaaccbbbabccbccacacacabaababbcbcccbbcacabcabbbccababbcccacccccabbcbcbbaabbaabacabaabbbbcccccccacabaacbbbbbcbbabccbacbaabccbabccbbabccbacccaaaababccbbbacaacaabcabbbabaabbcbcacbcabcabcacbabaaabbbcbbbcccaaacbcacccaabccabbcbbabbcaacabbcacabcbbaccaabbcccaaaaacbabbbccbbcccbaacaaccbccabaccbaabaacbaaaccbbcabbbacccaccaaccbcccbccacbaacbccbbaabbbaccbacaaabaaabcaacabcaccbbaaabcacacbaaacbccbabbbcbabbaaccccbcacaabacbbabbaccabccbacbabccbbaacacbacaccbacbbbaaabcaccabccaabccabbccbaacacbbbbccabcccaaabbcaccaaaaaaacccabcbaabccacaaaaacacacbbaaabbccaabccbaaccbbcabacaaaaabbbbbababacaaabbbcccbbbcacabaacabcbaaccbabbbabbaccacacaabcabbcaabbacaaacabbaccabcbcccccaacccaaacbcabbcbacabacbaccbccbbbbccbacabacabbbbbbbbccccbccccaabaabbcbacabaababcbbacbcabcccbabbcbcaacbaabbbccbbaccaccbbbccbacbccbcaccbccabacccbbccacbbcacaabaccbbccacbabaccaacbbbcacbbaccbcaaacbbabacacbaababbbacaabcccabbcbabccccaabcaaccbbbcbaababacbcaccaacabcbbbbcabbcccacbcbaccaabcccbcabcbaccbcbcccbccaacbccbaccacbccbabccbccaaaaaabcbacccbbbcbbacbacbabaacbbacacbbabccbccbcbbcbccaabaacccabbbbcbcbaccabcabacabccabbacccbabaccacabcbcbcacbabcccacbbaacbccaabcbaacaabaccaccbbcaabbbaabbbcbcabccabbabaccbbaccacccbabbbabaacbbbbaccaaaaabbcabbbbaabcbacbcccbacbcbbbacbcababbcbcbbbacaabbcaacaacbbbacabaacccaaccaacabbabcabccbbabccabacbccbaacacbacabbcaaccabaacccbcbcbccbbabacbcacbacaaaabbacacbcbbccbbbbccaacaabbabaacbbaaaababcccabcababccacbabbccaaccbccbbabaccacccbbacaaabcbaabbccccaababbcaabcabbccbbcbabcaabcbcbaccaaaaccbccacababbaacbaacbccbacabccabbbbbacbcbabacbaccbcabcbaabbcbcbbaccbabccababcbcbcbabbabbaabccacccbcabaccacbcbcbccbaacaabacbabccabaacbbabcbaccbcabcaaacacbaccccbcabbccccabcbaccabbbababbacabbacacbbaabaaaaababbcbbaabcbcacccbbbaabccaccabcbbbbbaababbbcaacbaaaaabbcbbabbaccbbacacbaaaabbcccbbcbcaacacbbaacaaabaacbaababbcaccaacbacabccabbabaaaacacabbabaabbaaacabccaabacaabcbaabbacaaaaacbbcbcabcacababcbabcbbbaacccbcbcacbbccbcacabcacbbbbcbabcbaaaacb"));
	}
	
	static String reverseShuffleMerge(String str) {
        int len = str.length();
        assert len%2==0;
        char[] res = new char[len/2];
        HashMap<Character, Integer> left = new HashMap<>(), need = new HashMap<>();
        char[] chars = str.toCharArray();
        for(char c : chars) {
            if(left.containsKey(c)) left.put(c, left.get(c)+1);
            else left.put(c, 1);
        }
        List<Character> targets = new ArrayList<>(left.keySet());
        Collections.sort(targets);
        for(char c : targets) {
            assert left.get(c)%2==0;
            need.put(c, left.get(c)/2);
        }
        Deque<Character> cache = new ArrayDeque<>();
        int tidx = 0, ridx = 0;
        char target = targets.get(tidx);
        for(int i=chars.length-1; i>=0&&ridx<res.length; i--) {
        	char c = chars[i];
        	
        	if(need.get('b')>=left.get('b')) {
        		int so = 1;
        	}
        	
            //update cache
            if(c==target) {
                cache.clear();
                cache.add(c);
            }else if(c>target) {
	            while(!cache.isEmpty()&&cache.getLast()>c) cache.removeLast();
	            cache.add(c);
            }
            
            //take chars
            if(left.get(c).equals(need.get(c)) //must take all the left chars
            		|| c==target ) { 
                while(!cache.isEmpty()) {
                	char t = cache.removeFirst();
                	if(t==target||need.get(t)>0) {
	                	res[ridx++] = t;
	                    need.put(t, need.get(t)-1);
                	}
                    if(t==c) {
                        break;
                    }
                }
            }
            
            //update target when c is the last target
            if(c==target&&need.get(c)==0) {
            	tidx++;
            	while(tidx<targets.size()&&need.get(targets.get(tidx))==0) tidx++;
            	if(tidx==targets.size()) break;
                target = targets.get(tidx);
            }
            
            //update left
            left.put(c, left.get(c)-1);
        }
        return String.valueOf(res);
    }
}
