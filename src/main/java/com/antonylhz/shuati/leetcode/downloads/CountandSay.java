public class Solution {
    public String countAndSay(int n) {
        if(n<1) return "";
        String seq = "1";
        if(n==1) return seq;
        for(int i=2; i<=n; i++) seq = getNext(seq);
        return seq;
    }
    public String getNext(String str) {
        StringBuffer res = new StringBuffer();
        int count = 0;
        int last = -1;
        for(int i=0; i<str.length(); i++) {
            int digit = Integer.parseInt(""+str.charAt(i));
            if(digit==last) {
                count++;
            } else {
                if(last>=0) {
                    res.append(String.valueOf(count));
                    res.append(String.valueOf(last));
                }
                count = 1;
                last = digit;
            }
        }
        res.append(String.valueOf(count));
        res.append(String.valueOf(last));
        return res.toString();
    }
}

