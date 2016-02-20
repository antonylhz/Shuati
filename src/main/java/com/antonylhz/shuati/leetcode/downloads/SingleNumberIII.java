public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] result = new int[2];
        Iterator<Integer> itr = set.iterator();
        for(int i=0; i<2; i++) result[i] = itr.next();
        return result;
    }
}