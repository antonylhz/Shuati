public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int cnt = 0;
        for (String s : strs) {
            String hc = hashcode(s);
            if (!map.containsKey(hc)) {
                map.put(hc, cnt++);
                res.add(new ArrayList<>());
            }
            res.get(map.get(hc)).add(s);
        }
        for (List<String> list : res) {
            Collections.sort(list);
        }
        return res;
    }

    private String hashcode(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
