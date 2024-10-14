package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
//        return findWordsBruteForce(board, words);
            return findWordsUsingTrie(board, words);
        }


        TrieNode root;
        private List<String> findWordsUsingTrie(char[][] board, String[] words) {
            root = new TrieNode();
            constructTrie(board);

            List<String> res = new ArrayList<>();
            for (String word : words) {
                if (search(word)) {
                    res.add(word);
                }
            }
            return res;
        }

        private void constructTrie(char[][] board) {
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    fillTrie(board, used, i, j, root);
                }
            }
        }

        private void fillTrie(char[][] board, boolean[][] used, int i, int j, TrieNode parent) {
            if (i < 0 || i > board.length - 1
                    || j < 0 || j > board[0].length - 1
                    || used[i][j]) {
                return;
            }

            char ch = board[i][j];
            TrieNode node = new TrieNode();
            node.isEndOfWord = true;
            parent.children[ch - 'a'] = node;

            used[i][j] = true;
            fillTrie(board, used, i-1, j, node);
            fillTrie(board, used, i, j+1, node);
            fillTrie(board, used, i+1, j, node);
            fillTrie(board, used, i, j-1, node);
            used[i][j] = false;
        }

        private boolean search(String word) {
            TrieNode current = root;
            int ind = 0;
            while (ind < word.length()) {
                char ch = word.charAt(ind++);
                TrieNode node = current.children[ch - 'a'];
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord;
        }

        private List<String> findWordsBruteForce(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                if (findWord(board, word)) {
                    res.add(word);
                }
            }
            return res;
        }

        private boolean findWord(char[][] board, String word) {
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (findWord(board, used, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean findWord(char[][] board, boolean[][] used, int i, int j, String word, int ind) {
            if (i < 0 || i > board.length-1 ||
                    j < 0 || j > board[i].length-1 ||
                    ind > word.length()-1 ||
                    used[i][j]) {
                return false;
            }
            char ch = word.charAt(ind);
            if (board[i][j] != ch) {
                return false;
            }
            if (ind == word.length() - 1) {
                return true;
            }

            used[i][j] = true;
            if (findWord(board, used, i-1, j, word, ind+1)
                    || findWord(board, used, i, j+1, word, ind+1)
                    || findWord(board, used, i+1, j, word, ind+1)
                    || findWord(board, used, i, j-1, word, ind+1)) {
                used[i][j] = false;
                return true;
            }
            used[i][j] = false;

            return false;
        }
    }
}
