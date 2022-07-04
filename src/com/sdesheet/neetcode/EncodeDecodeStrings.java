package com.sdesheet.neetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int count = Integer.parseInt(str.substring(i, j));
            i+=(j-i+1);
            strs.add(str.substring(i, i+count));
            i+=count;
        }
        return strs;
    }
}
