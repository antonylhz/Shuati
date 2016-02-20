public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i), tchar = t.charAt(i);
            if (!map1.containsKey(schar)) map1.put(schar, tchar);
            else if (map1.get(schar) != tchar) return false;
            if (!map2.containsKey(tchar)) map2.put(tchar, schar);
            else if (map2.get(tchar) != schar) return false;
        }
        return true;
    }
}