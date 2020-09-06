package com.antonylhz.shuati.leetcode.revised;

import java.util.*;

public class L642 {

    public static void main(String[] args) {
        try {
            String[] sentences = new String[]{
                    "i love you", "island", "iroman", "i love leetcode"
            };
            int[] times = new int[]{
                    5, 3, 2, 2
            };
            AutocompleteSystem autocomp = new AutocompleteSystem(sentences, times);
            for (char c : "i a#".toCharArray()) {
                System.out.println(c);
                System.out.println(autocomp.input(c));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class AutocompleteSystem {

    private SortedTrie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.trie = new SortedTrie(sentences, times);
    }

    public List<String> input(char c) {
        return trie.appendQuery(c);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

class SortedTrie {
    private Node root;
    private Map<String, Integer> weights;

    private String query;
    private Node cur;

    public SortedTrie() {
        this.root = new Node(' ');
        this.weights = new HashMap<>();
        this.query = "";
        this.cur = root;
    }

    public SortedTrie(String[] sentences, int[] times) {
        this();
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public void add(String str, int weight) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Node newNode = i < str.length() - 1 ? new Node(c) : new Node(c, str);
            node.children.putIfAbsent(c, newNode);
            node = node.children.get(c);
        }
        weights.put(str, weight);
    }

    public List<String> appendQuery(char c) {
        query = query + c;
        if (c != '#') {
            cur = cur.children.get(c);
        }
        List<String> res = new LinkedList<>();
        if (cur == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(cur);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.leaf) res.add(node.str);
            for (Node child : node.children.values()) {
                if (child != null) {
                    q.offer(child);
                }
            }
        }
        res.sort((s1, s2) -> {
            int diff = weights.get(s2) - weights.get(s1);
            if (diff != 0) return diff;
            return s1.compareTo(s2);
        });
        if (c == '#') saveFinishedQuery();
        return res.subList(0, Math.min(3, res.size()));
    }

    public void saveFinishedQuery() {
        weights.put(query, weights.getOrDefault(query, 0) + 1);
        query = "";
        cur = root;
    }

    class Node {
        char val;
        boolean leaf;
        String str;
        Map<Character, Node> children;
        public Node(char val) {
            this.val = val;
            this.leaf = false;
            this.children = new HashMap<>();
        }

        public Node(char val, String str) {
            this.val = val;
            this.str = str;
            this.leaf = true;
            this.children = new HashMap<>();
        }
    }
}

