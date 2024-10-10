package com.sdesheet.blind;

public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int ind = ch - 'a';
            if (current.children[ind] == null) {
                current.children[ind] = new TrieNode();
            }
            current = current.children[ind];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode current) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                if (i == word.length() - 1) {
                    // If it is the last character
                    for (TrieNode childNode : current.children) {
                        if (childNode != null && childNode.isEndOfWord) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    String subWord = word.substring(i+1, word.length());
                    for (TrieNode childNode : current.children) {
                        if (childNode != null && search(subWord, childNode)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            // Handle normal (smallcase) character
            int ind  = ch - 'a';
            if (current.children[ind] == null) {
                return false;
            }
            current = current.children[ind];
        }
        return current.isEndOfWord;
    }
}
