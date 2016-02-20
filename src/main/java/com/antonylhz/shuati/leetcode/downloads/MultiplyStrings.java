public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null||num1.length()==0||num2==null||num2.length()==0) return "";
        StringBuffer res = new StringBuffer("0");
        if(num1.length()<num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuffer tail = new StringBuffer();
        for(int i=num2.length()-1; i>=0; i--) {
            StringBuffer temp = new StringBuffer(num1);
            res = addString(res, multiplydigit(temp.append(tail), num2.charAt(i)));
            tail.append("0");
        }
        return res.toString();
    }
    public StringBuffer multiplydigit(StringBuffer num, char digit) {
        int numd = Integer.parseInt(""+digit);
        if(numd==0) return new StringBuffer("0");
        int carry = 0;
        StringBuffer result = new StringBuffer();
        for(int i=num.length()-1; i>=0; i--) {
            int temp = Integer.parseInt(""+num.charAt(i)) * numd + carry;
            carry = temp/10;
            temp %= 10;
            result.insert(0, temp);
        }
        if(carry>0) result.insert(0, String.valueOf(carry));
        return result;
    }
    public StringBuffer addString(StringBuffer num1, StringBuffer num2) {
        StringBuffer result = new StringBuffer();
        int carry = 0;
        int i1 = num1.length()-1, i2 = num2.length()-1;
        while(carry>0||(i1>=0&&i2>=0)) {
            int d1 = i1>=0?Integer.parseInt(""+num1.charAt(i1)):0;
            int d2 = i2>=0?Integer.parseInt(""+num2.charAt(i2)):0;
            int temp = carry + d1 + d2;
            carry = temp/10;
            temp -= carry*10;
            result.insert(0, String.valueOf(temp));
            i1--; i2--;
        }
        if(i1>=0) result.insert(0, num1.substring(0, i1+1));
        else if(i2>=0) result.insert(0, num2.substring(0, i2+1));
        if(result.length()==0) result.append("0");
        return result;
    }
}
