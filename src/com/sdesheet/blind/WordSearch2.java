package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode() {
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
        char[][] board;
        String[] words;
        boolean[][] used;
        Set<String> found;

        public List<String> findWordsUsingTrie(char[][] board, String[] words) {
            root = new TrieNode();
            this.words = words;
            for (String word : words) {
                addWord(word);
            }
            this.board = board;
            this.used = new boolean[board.length][board[0].length];
            StringBuilder sb = new StringBuilder();
            found = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    dfs(i, j, root, sb);
                }
            }
            return new ArrayList<>(found);
        }

        private void dfs(int i, int j, TrieNode current, StringBuilder path) {
            if (i < 0 || i > board.length-1
                    || j < 0 || j > board[i].length-1
                    || used[i][j]) {
                return;
            }
            char ch = board[i][j];
            current = current.children[ch - 'a'];
            if (current == null) {
                return;
            }
            path.append(ch);
            used[i][j] = true;
            if (current.isEndOfWord) {
                found.add(path.toString());
            }
            dfs(i-1, j, current, path);
            dfs(i, j+1, current, path);
            dfs(i+1, j, current, path);
            dfs(i, j-1, current, path);

            path.setLength(path.length()-1);
            used[i][j] = false;
        }

        private void addWord(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                TrieNode node = current.children[ch-'a'];
                if (node == null) {
                    node = new TrieNode();
                    current.children[ch-'a'] = node;
                }
                current = node;
            }
            current.isEndOfWord = true;
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
