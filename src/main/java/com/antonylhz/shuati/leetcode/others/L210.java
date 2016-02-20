package com.antonylhz.shuati.leetcode.others;

import java.util.*;

//Course Schedule II 
//
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//4, [[1,0],[2,0],[3,1],[3,2]]
//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3

public class L210 {
	
	private List<Integer> order = new ArrayList<Integer>(), 
						visited = new ArrayList<Integer>(), 
						courses = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
	}
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] res = new int[numCourses];
        Set hs = new HashSet();
        int index = 0;
        for(int i=0;i<numCourses;i++)
        graph[i] = new ArrayList();
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<numCourses; i++){
            if(hs.contains(i)) continue;
            Stack stack = new Stack();
            if(!dfs(graph,visited,i,stack,hs)) return (new int[0]);
            while(stack.size()!=0){
                int temp = (int)stack.pop();
                if(!hs.contains(temp)){
                    res[index++] = temp;
                    hs.add(temp);
                }
            }
        }
        return res;
    }
    
    private boolean dfs(ArrayList[] graph, boolean[] visited, int course,Stack stack,Set hs){
        if(visited[course]) return false;
        else if(hs.contains(course)) return true;
        else{
            stack.add(course);
            visited[course] = true;
        }
        for(int i=0; i<graph[course].size();i++) if(!dfs(graph,visited,(int)graph[course].get(i),stack,hs)) return false;
        visited[course] = false;
        return true;
    }
    
	public int[] canFinish2(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for(int i=0;i<numCourses;i++) graph.add(i, new ArrayList<Integer>());
        Queue<Integer> q = new LinkedList<Integer>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length;i++) {
        	graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        	indegree[prerequisites[i][0]]++;
        }
        for(int i=0; i<indegree.length; i++) {
        	if(indegree[i]==0) q.add(i);
        }
        List<Integer> courses = new ArrayList<Integer>();
        while(!q.isEmpty()) {
        	int course = q.poll();
        	courses.add(course);
        	for(int neighbor : graph.get(course)) {
        		indegree[neighbor]--;
        		if(indegree[neighbor]==0) {
        			q.add(neighbor);
        		}
        	}
        }
        if(courses.size()==numCourses) {
        	int[] result = new int[numCourses];
        	for(int i=0; i<numCourses; i++) result[i] = courses.get(i);
        	return result;
        } else return new int[]{};
	}
}
