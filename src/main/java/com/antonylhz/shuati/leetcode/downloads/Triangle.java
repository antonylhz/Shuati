public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0) return 0;
        int[] total = new int[triangle.size()];
        total[0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++) {
            total[i] = triangle.get(i).get(i) + total[i-1];
            for(int j=i-1; j>=1; j--) {
                total[j] = Math.min(total[j-1], total[j]) + triangle.get(i).get(j);
            }
            total[0] += triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for(int num : total) {
            if(num<min) min = num;
        }
        return min;
    }
}