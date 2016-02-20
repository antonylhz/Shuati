public class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        num = removeFactor(num, 2);
        num = removeFactor(num, 3);
        num = removeFactor(num, 5);
        return num==1;
    }

    int removeFactor(int num, int factor) {
        while(num%factor==0) {
            num = num/factor;
        }
        return num;
    }
}