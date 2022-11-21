package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = List.of("lint", "code", "love", "you");
        String encoded = encode(strs);
        System.out.println("encoded string : " + encoded);
        List<String> decodedStrs = decode(encoded);
        System.out.println("size: " + decodedStrs.size());
    }

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs.size()+",");
        for (String str : strs) {
            sb.append(str.length()+",");
            sb.append(str+",");
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        int ind = str.indexOf(",");
        int size = Integer.parseInt(str.substring(0, ind));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int next = str.indexOf(",", ind+1);
            int len = Integer.parseInt(str.substring(ind+1, next));
            list.add(str.substring(next+1, next+1+len));
            ind = next+1+len;
        }
        return list;
    }
}
