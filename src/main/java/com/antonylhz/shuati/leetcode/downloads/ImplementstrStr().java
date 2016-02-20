public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        else if (haystack.length() == 0) return -1;
        int nlength = needle.length(), hlength = haystack.length();
        int np = 0, hp = 0; //pointer of needle and haystack
        int lastknown = -1; //pointer of the last seen occurance of first character
        boolean matching = false;
        while (hp < hlength && np < nlength) {
            if (haystack.charAt(hp) == needle.charAt(np)) {
                if (matching && lastknown < 0 && haystack.charAt(hp) == needle.charAt(0)) lastknown = hp;
                if (np == 0) matching = true;
                np++;
                hp++;
            } else if (matching) {
                np = 0;
                if (lastknown > 0) {
                    hp = lastknown;
                    lastknown = -1;
                }
                matching = false;
            } else {
                hp++;
            }
        }
        if (matching && np == nlength) return hp - nlength;
        else return -1;
    }
}