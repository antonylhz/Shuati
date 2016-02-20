public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	for(int mask=0; mask<Math.pow(2, nums.length); mask++) {
    		List<Integer> subset = new ArrayList<Integer>();
    		int temp = mask, i = 0;
    		while(temp>0) {
    			if(temp%2>0) subset.add(nums[i]);
    			temp >>=1;
    			i++;
    		}
    		result.add(subset);
    	}
    	return result;
    }
}