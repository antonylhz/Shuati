class TrieNode {
    char val;
    boolean end;
    HashMap<Character, TrieNode> children;
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

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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
}

public class Solution {

    int width = 0, height = 0;
    Set<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {

        if(board==null||board.length==0||board[0].length==0||words==null||words.length==0)
            return new ArrayList<String>(result);

        height = board.length;
        width = board[0].length;

        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);

        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
                dfs(board, i, j, trie.root, "");
            }

        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, String word) {
        if(i<0||i>=height||j<0||j>=width) return;
        if(!node.children.containsKey(board[i][j])) return;

        String newword = word + board[i][j];
        node = node.children.get(board[i][j]);
        if(node.end) result.add(newword);

        board[i][j] ^= 256;
        dfs(board, i-1, j, node, newword);
        dfs(board, i+1, j, node, newword);
        dfs(board, i, j-1, node, newword);
        dfs(board, i, j+1, node, newword);
        board[i][j] ^= 256;
    }
}
