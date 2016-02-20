public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int base = 1, i;
        for(i=1; i<=n; i++) {
            list.add(i);
            base *= i;
        }
        base /= n; i = n-1;
        StringBuilder sb = new StringBuilder();
        while(list.size()>1) {
            sb.append(list.remove((k-1)/base));
            k %= base;
            if(k==0) k = base;
            base /= (i--);
        }
        if(!list.isEmpty()) sb.append(list.remove(0));
        return sb.toString();
    }
}