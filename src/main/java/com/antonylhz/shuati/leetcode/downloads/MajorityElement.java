public class Solution {
	//Moore voting algorithm
    public int majorityElement(int[] nums) {
        int count = 0, result = 0;
        for(int num : nums) {
        	if(count==0) {
        		count++;
        		result = num;
        	} else {
        		if(num==result) count++;
        		else count--;
        	}
        }
        return result;
    }
}