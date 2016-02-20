public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || L == null || L.length < 1 || S.length() < L.length * L[0].length()) return result;
        int len = L[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        for (int i = 0; i < S.length(); i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) {
                if (i + len * j + len > S.length()) return result;
                String str = S.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(str)) {
                    if (copy.get(str) > 1) copy.put(str, copy.get(str) - 1);
                    else copy.remove(str);
                }
            }
            if (copy.isEmpty()) result.add(i);
        }
        return result;
    }
}