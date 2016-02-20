package com.antonylhz.shuati.leetcode;

public class L8 {
	public static void main(String[] args) {
		String str = "2147483648";
		int number = (new L8()).atoi(str);
		System.out.println(number);
	}
	
    public int atoi(String str) {
        char[] chars = str.toCharArray();
        boolean isNeg = false;
        int result=0, i=0;
        while(i<chars.length&&chars[i]==' ') i++;
        if(i==chars.length) return 0;
        if(chars[i]=='+') i++;
        else if(chars[i]=='-') {
            isNeg = true;
            i++;
        }
        while(i<chars.length&&chars[i]=='0') i++;
        int digits = 0, temp;
        while(i<chars.length&&!(chars[i]==' ')) {
            temp = chars[i]-'0';
            if(temp>9||temp<0) 
                return isNeg?-result:result;
            digits++;
            if(digits>=10) {
                int last = Integer.MAX_VALUE%10;
                int left = (Integer.MAX_VALUE-last)/10;
                if(result>left || result==left&&temp>last) 
                    return isNeg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            result*=10;
            result+=temp;
            i++;
        }
        while(i<chars.length) {
            if(chars[i++]!=' ') 
                return 0;
        }
        return isNeg?-result:result;
    }
}
