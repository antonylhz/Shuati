public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] schar = s.toCharArray(), tchar = t.toCharArray();
        for(char c : schar) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for(char c : tchar) {
            if(map.containsKey(c)) {
                if(map.get(c)==1) map.remove(c);
                else map.put(c, map.get(c)-1);
            } else return false;
        }
        return map.isEmpty();
    }
}