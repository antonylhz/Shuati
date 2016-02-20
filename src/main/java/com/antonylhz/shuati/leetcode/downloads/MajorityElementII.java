public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0, num1 = 0, num2 = 0, cnto = 0;
        for(int num : nums) {
            if(cnt1==0) {
                num1 = num;
                cnt1++;
            } else if(num==num1) {
                cnt1++;
            } else if(cnt2==0) {
                num2 = num;
                cnt2++;
            } else if(num==num2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;

            }
        }
        List<Integer> result = new ArrayList<Integer>();
        if(cnt1==0&&cnt2==0) return result;
        if(cnt1>0&&isMajority(nums,num1)) result.add(num1);
        if(num2!=num1&&cnt2>0&&isMajority(nums, num2)) result.add(num2);
        return result;
    }

    private boolean isMajority(int[] nums, int target) {
        int cnt = 0;
        for(int num : nums) {
            if(num==target)
                cnt++;
        }
        return cnt>nums.length/3;
    }
}
