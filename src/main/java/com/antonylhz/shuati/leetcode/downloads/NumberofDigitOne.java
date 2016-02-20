public class Solution {
    public int countDigitOne(int n) {
        if(n<=0) return 0;
        else if(n<10) return 1;
        int capacity = 10;
        while(n/capacity>=10)
        	capacity *= 10;
        int first_digit = n/capacity;
        int count = 0;
        if(first_digit == 1) {
            count += n-capacity+1; //ones as the first digit
        } else {
            count += capacity; //ones as the first digit
        }
        count += first_digit*countDigitOne(capacity-1); //ones in the remaining digits when the first digit is less than current value
        count += countDigitOne(n-capacity*first_digit); //ones in the remaining digits when the first digit is larger than current value
        return count;
    }
}