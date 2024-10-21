package com.sdesheet.blind;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return search(word, 0, root);
    }

    public boolean search(String word, int ind, TrieNode current) {
        for (int i = ind; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode node : current.children) {
                    if (node == null) {
                        continue;
                    }
                    if (ind == word.length()-1) {
                        if (node.isEndOfWord) {
                            return true;
                        }
                    }
                    else if (search(word, i+1, node)) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode node = current.children[ch-'a'];
                if (node == null) {
                    return false;
                }
                current = node;
            }
        }
        return (current != null && current.isEndOfWord);
    }
}
