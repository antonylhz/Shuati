public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        if (strs[0] == "") return "";
        else if (strs.length == 1) return strs[0];
        char[] result = strs[0].toCharArray();
        char[] str;
        int count = result.length;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == "") return "";
            str = strs[i].toCharArray();
            count = count > str.length ? str.length : count;
            for (int j = 0; j < count && j < str.length; j++) {
                if (str[j] != result[j]) {
                    count = j;
                    break;
                }
            }
        }
        return String.valueOf(result, 0, count);
    }
}