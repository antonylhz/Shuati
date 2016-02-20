public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null) return 0;
        int size = num.length;
        if (size == 0) return 0;
        else if (size == 1) return 1;
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        int result = 0;
        for (int i = 0; i < size; i++) {
            hm.put(num[i], false);
        }
        for (int i = 0; i < size; i++) {
            Integer cur = new Integer(num[i]);
            int length = 1;
            if (hm.get(cur)) continue;
            for (Integer prev = cur - 1; ; prev--) {
                if (!hm.containsKey(prev)) break;
                hm.put(prev, true);
                length++;
            }
            for (Integer next = cur + 1; ; next++) {
                if (!hm.containsKey(next)) break;
                hm.put(next, true);
                length++;
            }
            result = result >= length ? result : length;
        }
        return result;
    }
}