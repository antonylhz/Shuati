public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if(n<=0) return result;
        result.add(1);
        if(n==1) return result;
        List<Integer> prev = grayCode(n-1);
        result.clear();
        result.addAll(prev);
        int lead = 1<<(n-1);
        for(int i=prev.size()-1; i>=0; i--) {
            result.add(lead+prev.get(i));
        }
        return result;
    }
}