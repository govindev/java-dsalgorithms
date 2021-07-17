package com.leetcode.topinterviewquestions;

import java.util.*;

class Obj {
	String word;
	int len;

	Obj(String word, int len) {
		this.word = word;
		this.len = len;
	}
}

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// This is to figure out the adjancency before.Something which is not required
		// boolean[][] pair = new boolean[wordList.size()][wordList.size()];
		// for (int i = 0; i < wordList.size(); i++) {
		// for (int j = 0; j < wordList.size(); j++) {
		// if (i == j || pair[j][i]) pair[i][j] = true;
		// else pair[i][j] = isRightPair(wordList.get(i), wordList.get(j))
		// }
		// }
		if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() < 1)
			return 0;

		Queue<Obj> q = new LinkedList<>();
		q.add(new Obj(beginWord, 1));
		while (!q.isEmpty()) {
			Obj curr = q.poll();
			ListIterator<String> itr = wordList.listIterator();
			while (itr.hasNext()) {
				String temp = itr.next();
				if (isAdjancent(curr.word, temp)) {
					itr.remove();
					q.add(new Obj(temp, curr.len + 1));
					if (temp.equals(endWord))
						return curr.len + 1;
				}
			}
		}
		return 0;
	}

	public boolean isAdjancent(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;
		int count = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}
}
