public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean carry = true;
        int i=len-1, temp;
        while(i>=0 && carry) {
            temp = digits[i] + 1;
            if(temp<10) {
                digits[i] = temp;
                carry = false;
                break;
            } else {
                temp-=10;
                digits[i] = temp;
                i--;
            }
        }
        if(!carry) return digits;
        else {
            int[] result = new int[len+1];
            result[0] = 1;
            for(int j=0; j<len; j++) result[j+1] = digits[j];
            return result;
        }
    }
}