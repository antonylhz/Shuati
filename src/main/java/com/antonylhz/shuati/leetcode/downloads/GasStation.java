public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i=0; i<gas.length; i++){
            sum += (gas[i] - cost[i]);
            if (sum < min){
                min = sum;
                minIndex = i;
            }
        }

        if (sum < 0)
            return -1;

        if (minIndex == gas.length - 1)
            return 0;
        else return minIndex + 1;
    }
}