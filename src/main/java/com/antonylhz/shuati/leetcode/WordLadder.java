package com.antonylhz.shuati.leetcode;
import java.util.*;
public class WordLadder {
	public static void main(String[] args) {
		WordLadder solution = new WordLadder();
		Set<String> dict = new HashSet<String>();
		String[] strs = new String[]{"most","mist","miss","lost","fist","fish"};
		for(String str : strs) dict.add(str);
		
		//long starttime = System.currentTimeMillis();
		//System.out.println(solution.ladderLength("nape", "mild", dict));
		//System.out.println("Time: "+(System.currentTimeMillis()-starttime));
		
		long starttime = System.currentTimeMillis();
		System.out.println(solution.findLadders3("lost", "miss", dict));
		System.out.println("Time: "+(System.currentTimeMillis()-starttime));
		
		//System.out.println(solution.findLadders("nape", "mild", dict));
		//System.out.println("Time: "+(System.currentTimeMillis()-starttime));
		
		//System.out.println(solution.findLadders2("nape", "mild", dict));
		//System.out.println("Time: "+(System.currentTimeMillis()-starttime));
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> queue = new ArrayList<List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        temp.add(start);
        queue.add(temp);
        if(dict.contains(start)) dict.remove(start);
        if(!dict.contains(end)) dict.add(end);
        boolean found = false;
        int level = 0;
        while (!found&&!queue.isEmpty()) {
            int size = queue.size();
            HashSet<String> removeList = new HashSet<String>();
            for(int j=0; j<size; j++) {
                List<String> q = queue.remove(0);
                String last = q.get(level);
                if(last.equals(end)) {
                    if(!found) found = true;
                    result.add(q);
                } else if(!found){
                    for (int i = 0; i < start.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            String s = last.substring(0, i) + c + last.substring(i + 1, start.length());
                            if (dict.contains(s)) {
                            	temp = new ArrayList<String>();
                            	temp.addAll(q);
                                temp.add(s);
                                queue.add(temp);
                                if(!s.equals(end)) removeList.add(s);
                            }
                        }
                    }
                }
            }
            dict.removeAll(removeList);
            level++;
        }
        return result;  
    }
    
    public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
    	List<List<String>> res=new LinkedList<>();
        List<String> list=new LinkedList<>();
        Set<String> qu=new HashSet<>();//I use a set instead of a queue to implement the bfs.
        Map<String,Set<String>> map=new HashMap<>();// store all visited strings and their parents
        map.put(start,null);
        qu.add(start);
        boolean flag=false;// to store whether one of shortest path is found or not.
        while(!qu.isEmpty()){
            Set<String> qu1=new HashSet<>();
            for(String temp:qu){
	            char[] charArray=temp.toCharArray();
	            for(int i=0;i<charArray.length;i++){
	                for(char j='a';j<='z';j++){
	                    if(j==temp.charAt(i)) continue;
	                    charArray[i]=j;
	                    String str=String.valueOf(charArray);
	                    if(str.equals(end)){
	                        list.add(temp);
	                        flag=true;
	                    }
	                    else{
	                        if(dict.contains(str)&&!flag){
	                         //IMPORTANT: even str is visited, we need to add temp as its parents.
	                            if(qu1.contains(str)){
	                               map.get(str).add(temp);
	                            }
	                            else if(!map.containsKey(str)){
	                                qu1.add(str);
	                                Set<String> myset=new HashSet<>();
	                                myset.add(temp);
	                                map.put(str,myset);
	                            }
	                        }
	                    }
	                }
	                charArray[i]=temp.charAt(i);
	            }
            }
            if(flag) break;// If shortest path has been found, break.
              qu=qu1;
          }
         // build path
          for(String s:list){
              List<String> temp=new ArrayList<>();
              temp.add(end);
              findPath(s,start,temp,map,res);
          }
          return res;
    }
    
    public void findPath(String s,String start,List<String> list,Map<String,Set<String>> map,List<List<String>> res){
        list.add(0,s);
        if(s.equals(start)){
            res.add(new ArrayList<>(list));
        }
        else{
            for(String str:map.get(s)){
                findPath(str,start,list,map,res);
            }
        }
        list.remove(0);
    }
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        wordDict.add(endWord);
        int count = 0;
        while(q.size()>0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String word = q.poll();
                if(word.equals(endWord)) return count;
                for(int j=0; j<word.length(); j++) {
                    for(char c='a'; c<='z'; c++) {
                        String target = word.substring(0, j) + c + word.substring(j+1, word.length());
                        if(wordDict.contains(target)) {
                            q.add(target);
                            wordDict.remove(target);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
    
    public int ladderLength2(String start, String end, Set<String> dict) {
        List<String> queue = new ArrayList<String>();
        queue.add(start);
        dict.add(end);
        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for(int j=0; j<size; j++) {
                String q = queue.remove(0);
                if (q.equals(end))
                    return dist;
                for (int i = 0; i < start.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String s = q.substring(0, i) + c + q.substring(i + 1, start.length());
                        if (dict.contains(s)) {
                            queue.add(s);
                            dict.remove(s);
        }}}}}
        return 0;
    }
    
    public List<List<String>> findLadders3(String start, String end, Set<String> dict) {
        HashMap<String, Set<String>> map = new HashMap<>();
        Set<String> q = new HashSet<String>();
        q.add(start);
        dict.remove(start);
        dict.add(end);
        int depth = 0;
        boolean found = false;
        while(!q.isEmpty() && !found) {
            Set<String> level = new HashSet<String>(), remove = new HashSet<String>();
            for(String word : q) {
                if(word.equals(end)) found = true;
                char[] chars = word.toCharArray();
                for(int i=0; i<word.length(); i++) {
                    char temp = chars[i];
                    for(char c = 'a'; c<='z'; c++) {
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        chars[i] = temp;
                        if(dict.contains(target)) {
                            level.add(target);
                            remove.add(target);
                            if(!map.containsKey(target)) {
                                Set<String> parents = new HashSet<String>();
                                map.put(target, new HashSet<String>());
                            }
                            map.get(target).add(word);
                        }
                    }
                }
            }
            q = level;
            for(String word : remove) dict.remove(word);
            depth++;
        }
        List<List<String>> result = new ArrayList<>();
        if(!map.containsKey(end)) return result;
        List<String> seed = new ArrayList<String>();
        seed.add(end);
        result.add(seed);
        for(int i=0; i<depth-1; i++) {
            int size = result.size();
            for(int j=0; j<size; j++) {
                List<String> ladder = result.get(j);
                String head = ladder.get(0);
                if(map.containsKey(head)) {
                    for(String parent : map.get(head)) {
                        List<String> newladder = new ArrayList<String>(ladder);
                        newladder.add(0, parent);
                        result.add(newladder);
                    }
                }
            }
            result.subList(0, size).clear();
        }
        return result;
    }
}
