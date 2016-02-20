package com.antonylhz.shuati.leetcode;

//Word Search II 
//
//Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

import java.util.*;

public class L212 {
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
