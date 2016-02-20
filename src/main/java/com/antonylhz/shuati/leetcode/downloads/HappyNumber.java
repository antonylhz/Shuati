public class Solution {
    public boolean isHappy(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int cur = n;
        map.put(cur, true);
        while(cur!=1) {
            int temp = cur;
            cur = 0;
            while(temp>0) {
                int digit = temp%10;
                cur += digit*digit;
                temp /= 10;
            }
            if(map.containsKey(cur)) return false;
            map.put(cur, true);
        }
        return cur==1;
    }
}