public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums==null||nums.length==0) return result;
        int start = nums[0], last = start;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=last+1) {
                result.add(getRange(start, last));
                start = nums[i];
            }
            last = nums[i];
        }
        result.add(getRange(start, last));
        return result;
    }
    private String getRange(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(start));
        if(end!=start) {
            sb.append("->");
            sb.append(String.valueOf(end));
        }
        return sb.toString();
    }
}