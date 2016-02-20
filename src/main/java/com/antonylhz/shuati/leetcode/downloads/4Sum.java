public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> rslt = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0;i < num.length-3;i++){
            if(i==0 || i> 0 && num[i]!=num[i-1]){
            for(int j = i+1;j < num.length-2;j++){
                if(j==i+1 || j > i+1 && num[j]!= num[j-1]){
                    int rest = target - num[i] - num[j];
                    int low = j+1, high = num.length-1;
                    while(low < high){
                        int sum = num[low] + num[high];
                        if(sum == rest){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(num[i]); list.add(num[j]); list.add(num[low]); list.add(num[high]);
                            rslt.add(list);
                            while(high > low && num[high] == num[--high]);
                            while(high > low && num[low] == num[++low]);
                        }
                        else if(sum > rest) high--;
                        else low++;
                    }
                }
            }}
        }
        return rslt;
    }
}
