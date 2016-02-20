package com.antonylhz.shuati.leetcode.revised;

//Course Schedule 
//
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L207 {
	public static void main(String[] args) {
		
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for(int i=0;i<numCourses;i++) graph.add(i, new ArrayList<Integer>());
        for(int i=0; i<prerequisites.length;i++) graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) if(!dfs(graph, visited, i)) return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int course){
        if(visited[course]) return false;
        visited[course] = true;
        for (int i = 0; i < graph.get(course).size(); i++)
            if (!dfs(graph, visited, graph.get(course).get(i))) return false;
        visited[course] = false;
        return true;
    }
    
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
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
        return courses.size()==numCourses;
	}

}
