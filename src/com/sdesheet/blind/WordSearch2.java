package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> foundWords;
        char[][] board;
        boolean[][] used;
        private List<String> findWordsUsingTrie(char[][] board, String[] words) {
            constructTrie(words);
            this.board = board;
            this.used = new boolean[board.length][board[0].length];
            findWords();

            return new ArrayList<>(foundWords);
        }

        private void constructTrie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                constructTrie(word);
            }
        }

        private void constructTrie(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                TrieNode node = current.children[ch - 'a'];
                if (node == null) {
                    node = new TrieNode();
                    current.children[ch - 'a'] = node;
                }
                current = node;
            }
            current.isEndOfWord = true;
        }

        private void findWords() {
            foundWords = new HashSet<>();
            List<Character> path = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    findWords(i, j, root, path);
                }
            }
        }

        private void findWords(int i, int j, TrieNode current, List<Character> chars) {
            if (i < 0 || i > board.length-1
                    || j < 0 || j > board[i].length-1
                    || current == null
                    || used[i][j]) {
                return;
            }
            char ch = board[i][j];
            TrieNode node = current.children[ch - 'a'];
            if (node == null) {
                return;
            }
            chars.add(ch);
            used[i][j] = true;
            if (node.isEndOfWord) {
                foundWords.add(getWord(chars));
            }
            findWords(i-1, j, node, chars);
            findWords(i, j+1, node, chars);
            findWords(i+1, j, node, chars);
            findWords(i, j-1, node, chars);
            chars.removeLast();
            used[i][j] = false;
        }

        private String getWord(List<Character> chars) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : chars) {
                sb.append(ch);
            }
            return sb.toString();
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
