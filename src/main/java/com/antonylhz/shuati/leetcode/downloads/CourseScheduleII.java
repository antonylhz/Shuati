public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) graph.add(new HashSet<Integer>());
        int[] indegrees = new int[numCourses];
        List<Integer> zeros = new ArrayList<Integer>(), courses = new ArrayList<Integer>();
        for(int[] prq : prerequisites) {
            if(!graph.get(prq[1]).contains(prq[0])) {
                graph.get(prq[1]).add(prq[0]);
                indegrees[prq[0]]++;
            }
        }
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i]==0) zeros.add(i);
        }
        while(zeros.size()>0) {
            List<Integer> next_zeros = new ArrayList<Integer>();
            for(int course : zeros) {
                for(int child : graph.get(course)) {
                    indegrees[child]--;
                    if(indegrees[child]==0)
                        next_zeros.add(child);
                }
            }
            courses.addAll(zeros);
            zeros = next_zeros;
        }
        if(courses.size()!=numCourses) return new int[0];
        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++) result[i] = courses.get(i);
        return result;
    }
}
