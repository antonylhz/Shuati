public class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length<2) return new int[0];
        for(int i=0; i<numbers.length; i++) {
            int leftover = target - numbers[i];
            if(!map.isEmpty() && map.containsKey(leftover)) return new int[]{map.get(leftover), i+1};
            if(map.isEmpty() || !map.containsKey(numbers[i])) map.put(numbers[i],i+1);
        }
        return new int[0];
    }
}