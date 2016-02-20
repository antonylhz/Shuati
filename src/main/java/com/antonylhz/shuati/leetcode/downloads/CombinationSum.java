public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> options = new ArrayList<List<Integer>>(), result = new ArrayList<List<Integer>>();
        List<Integer> sums = new ArrayList<Integer>();
        Arrays.sort(candidates);
        options.add(new ArrayList<Integer>());
        sums.add(0);
        for(int cand : candidates) {
        	boolean done = false;
            int scale = 1;
            int size = sums.size();
            while(size>0&&!done) {
                for(int i=0; i<size; i++) {
                    List<Integer> temp = new ArrayList<Integer>(options.get(i));
                    if(sums.get(i)+scale*cand==target) {
                        for(int candi=0; candi<scale; candi++) temp.add(cand);
                        result.add(temp);
                        if(scale==1) {
	                        options.remove(i);
	                        sums.remove(i);
	                        size--;
                        }
                    } else if(sums.get(i)+scale*cand<target) {
                        for(int candi=0; candi<scale; candi++) temp.add(cand);
                        options.add(temp);
                        sums.add(sums.get(i)+scale*cand);
                    } else {
                        if(i==0) done = true;
                    }
                }
                scale++;
            }
        }
        return result;
    }
}
