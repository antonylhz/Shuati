public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) return -1;
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            int next = i + 1, last = num.length - 1;
            while (next < last) {
                int temp = num[i] + num[next] + num[last];
                if (temp == target) return target;
                else if (Math.abs(target - temp) < Math.abs(target - result)) result = temp;
                if (temp < target) next++;
                else last--;
            }
        }
        return result;
    }
}