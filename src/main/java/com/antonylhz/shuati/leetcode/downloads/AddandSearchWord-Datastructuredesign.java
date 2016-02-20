class TrieNode {
    char val;
    boolean end;
    HashMap<Character, TrieNode> children;
    // Initialize your data structure here.
    public TrieNode() {
        this.val = ' ';
        this.end = false;
        this.children = new HashMap<Character, TrieNode>();
    }
    public TrieNode(char val) {
        this.val = val;
        this.end = false;
        this.children = new HashMap<Character, TrieNode>();
    }
}

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for(char c : chars) {
            if(!cur.children.containsKey(c)) {
                TrieNode newnode = new TrieNode(c);
                cur.children.put(c, newnode);
            }
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        List<TrieNode> candidates = new ArrayList<TrieNode>();
        candidates.add(root);
        int i=0;
        while(i<word.length()&&!candidates.isEmpty()) {
            List<TrieNode> new_candidates = new ArrayList<TrieNode>();
            for(TrieNode cur : candidates) {
                if(chars[i]=='.') {
                    new_candidates.addAll(cur.children.values());
                } else {
                    if(cur.children.containsKey(chars[i])) {
                        new_candidates.add(cur.children.get(chars[i]));
                    }
                }
            }
            candidates = new_candidates;
            i++;
        }
        if(candidates.isEmpty()) return false;
        for(TrieNode candidate : candidates) {
            if(candidate.end)
                return true;
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

