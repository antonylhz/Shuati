public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String, Set<String>> map = new HashMap<>();
        Set<String> q = new HashSet<String>();
        q.add(start);
        dict.remove(start);
        dict.add(end);
        int depth = 0;
        boolean found = false;
        while (!q.isEmpty() && !found) {
            Set<String> level = new HashSet<String>(), remove = new HashSet<String>();
            for (String word : q) {
                if (word.equals(end)) found = true;
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char temp = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        chars[i] = temp;
                        if (dict.contains(target)) {
                            level.add(target);
                            remove.add(target);
                            if (!map.containsKey(target)) {
                                Set<String> parents = new HashSet<String>();
                                map.put(target, new HashSet<String>());
                            }
                            map.get(target).add(word);
                        }
                    }
                }
            }
            q = level;
            for (String word : remove) dict.remove(word);
            depth++;
        }
        List<List<String>> result = new ArrayList<>();
        if (!map.containsKey(end)) return result;
        List<String> seed = new ArrayList<String>();
        seed.add(end);
        result.add(seed);
        for (int i = 0; i < depth - 1; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<String> ladder = result.get(j);
                String head = ladder.get(0);
                if (map.containsKey(head)) {
                    for (String parent : map.get(head)) {
                        List<String> newladder = new ArrayList<String>(ladder);
                        newladder.add(0, parent);
                        result.add(newladder);
                    }
                }
            }
            result.subList(0, size).clear();
        }
        return result;
    }
}

