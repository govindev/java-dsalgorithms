package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0, s, path, res);
        return res;
    }

    private void func(int ind, String s, List<String> path, List<List<String>> res) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                path.add(s.substring(ind, i+1));
                func(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
