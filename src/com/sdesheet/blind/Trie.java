package com.sdesheet.blind;

public class Trie {
    class TrieNode {
        Boolean isEndOfWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode temp = current.children[ch-'a'];
            if (temp == null) {
                temp = new TrieNode();
                current.children[ch-'a'] = temp;
            }
            current = temp;
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode endCharTrieNode = getEndCharTrieNode(word);
        if (endCharTrieNode == null) {
            return false;
        }
        return endCharTrieNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = getEndCharTrieNode(prefix);
        return (node != null);
    }


    private TrieNode getEndCharTrieNode(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current == null) {
                break;
            }
            current = current.children[ch-'a'];
        }
        return current;
    }
}
