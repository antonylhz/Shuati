public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums) list.add(num);
        return permute(list);
    }
    private List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.size(); i++) {
            int head = nums.get(i);
            nums.remove(i);
            List<List<Integer>> permutations = permute(nums);
            if(permutations.isEmpty()) permutations.add(new ArrayList<Integer>());
            for(List<Integer> perm : permutations) perm.add(0, head);
            result.addAll(permutations);
            nums.add(i, head);
        }
        return result;
    }
}