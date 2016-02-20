package com.antonylhz.shuati.leetcode;

//Implement Trie (Prefix Tree)

import java.util.*;

public class L208 {
	
}


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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for(char c : chars) {
            if(!cur.children.containsKey(c))
                return false;
            cur = cur.children.get(c);
        }
        return cur.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for(char c : chars) {
            if(!cur.children.containsKey(c))
                return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
