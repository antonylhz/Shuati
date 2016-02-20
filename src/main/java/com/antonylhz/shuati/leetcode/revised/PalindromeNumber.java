package com.antonylhz.shuati.leetcode.revised;

public class PalindromeNumber {
	public static void main(String[] args) {
		int number = 1410110141;
		System.out.println((new PalindromeNumber()).isPalindrome(number));
	}
	
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        else if(x<10) return true;
        int base1=1, base2=10;
        while(x/base2>9) base2*=10;
        int d1, d2;
        while(base2>=base1*10) {
            d1 = x%(base1*10)/base1;
            if(Integer.MAX_VALUE/10<base2) d2 = x/base2;
            else d2 = x%(base2*10)/base2;
            if(d1!=d2) return false;
            base1*=10;
            base2/=10;
        }
        return true;
    }
}
