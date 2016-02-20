public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> options = new ArrayList<List<Integer>>(), result = new ArrayList<List<Integer>>();
        List<Integer> sums = new ArrayList<Integer>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        Arrays.sort(candidates);
        options.add(new ArrayList<Integer>());
        sums.add(0);
        for (int cand : candidates) {
            boolean done = false;
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<Integer>(options.get(i));
                if (sums.get(i) + cand == target) {
                    temp.add(cand);
                    if (map.isEmpty() || !map.containsKey(getHash(temp))) {
                        result.add(temp);
                        map.put(getHash(temp), true);
                    }
                } else if (sums.get(i) + cand < target) {
                    temp.add(cand);
                    options.add(temp);
                    sums.add(sums.get(i) + cand);
                }
            }
        }
        return result;
    }

    private String getHash(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(":");
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }
}
