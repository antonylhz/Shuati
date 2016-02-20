public class Solution {
    public int findMin(int[] num) {
        return findMinFromSubArray(num, 0, num.length - 1);
    }

    private int findMinFromSubArray(int[] num, int st, int en) {
        if(st >= en) return num[st];
        //Trim ends of equal elements
        while(st < en && num[st] == num[st+1]) st++;
        while(st < en && num[en] == num[en-1]) en--;

        if(st == en) return num[st];
        if(en - st == 1) return num[en] < num[st] ? num[en]: num[st];

        int mid = (st + en) / 2;
        boolean lfUp = leftUptrend(num, st, mid);
        boolean rtUp = rightUptrend(num, mid, en);
        if(!lfUp && rtUp) return num[mid];
        if(num[st] < num[en]) {
            if(lfUp && rtUp) return num[st];
            if(!lfUp && ! rtUp) {
                if(num[mid] < num[st]) return findMinFromSubArray(num, mid, en);
                else return findMinFromSubArray(num, st, mid);
            }
            else return findMinFromSubArray(num, st, mid);
        } else {
            if(!lfUp && !rtUp) return num[en];
            if(lfUp && rtUp) {
                if(num[mid] > num[st]) return findMinFromSubArray(num, mid, en);
                else return findMinFromSubArray(num, st, mid);
            }
            else return findMinFromSubArray(num, mid, en);
        }
    }

    //Ensure that st != en. The default is to make it false
    private boolean leftUptrend(int[] num, int st, int en) {
        int i = en - 1;
        while(num[i] == num[en]) {
            if(i == 0) return false; //No trend found
            i--;
        }
        //Now we find a element not equal
        return num[i] < num[en] ? true : false;
    }

    //Ensure that st != en. The default is to make it true
    private boolean rightUptrend(int[] num, int st, int en) {
        int i = st + 1;
        while(num[i] == num[st]) {
            if(i == en) return true; // No trend found
            i++;
        }
        //Now we find a element not equal
        return num[i] < num[st] ? false : true;
    }

}