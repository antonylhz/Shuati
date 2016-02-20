public class Solution {
	public int lengthOfLongestSubstring(String s) {
        boolean[] mask = new boolean[128];
        Arrays.fill(mask, false);
        if(s==null||s.length()==0) return 0;
        else if(s.length()==1) return 1;
        int i=0, j=1, max=1, newlength;
        mask[s.charAt(0)] = true;
        while(j<s.length()) {
            char c = s.charAt(j);
            if(!mask[c]) {
                mask[c] = true;
                newlength = (j++) - i + 1;
            } else {
                while(s.charAt(i)!=c) mask[(int)s.charAt(i++)] = false;
                if(i<j) {
                    newlength = (j++)-(i++);
                } else {
                    newlength = (++j)-i;
                }
            }
            max = newlength > max ? newlength : max;
        }
        return max;
    }
}