public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        List<String> q = new ArrayList<String>();
        q.add(beginWord);
        wordDict.add(endWord);
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            List<String> level = new ArrayList<String>();
            for(String word : q) {
                if(word.equals(endWord)) return count;
                char[] chars = word.toCharArray();
                for(int i=0; i<word.length(); i++) {
                    char temp = chars[i];
                    for(char c='a'; c<='z'; c++) {
                        chars[i] = c;
                        String target = String.copyValueOf(chars);
                        chars[i] = temp;
                        if(wordDict.contains(target)) {
                            level.add(target);
                            wordDict.remove(target);
                        }
                    }
                }
            }
            q = level;
        }
        return 0;
    }
}
