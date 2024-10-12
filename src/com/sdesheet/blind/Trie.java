package com.sdesheet.blind;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children[ch-'a'];
            if (node == null) {
                node = new TrieNode();
            }
            current.children[ch-'a'] = node;
            current = node;
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode wordsEndTrieNode = getWordsEndTrieNode(word);
        if (wordsEndTrieNode == null) {
            return false;
        }
        return wordsEndTrieNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode wordsEndTrieNode = getWordsEndTrieNode(prefix);
        return (wordsEndTrieNode != null);
    }

    private TrieNode getWordsEndTrieNode(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children[ch-'a'];
            if (node == null) {
                return node;
            }
            current = node;
        }
        return current;
    }
}
