package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = List.of("lint", "code", "love", "you");
        String encoded = encodeNeetCode(strs);
        System.out.println("encoded string : " + encoded);
        List<String> decodedStrs = decodeNeetCode(encoded);
        System.out.println("size: " + decodedStrs.size());
        System.out.println("strings: " + decodedStrs);
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


    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encodeBetter(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(':');
        }
        sb.append(';');
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decodeBetter(String str) {
        List<String> res = new ArrayList<>();

        int sepOcc = str.indexOf(';');
        String countStr = str.substring(0, sepOcc-1);
        String[] counts = countStr.split(":");

        String concStr = str.substring(sepOcc+1);

        int start = 0;
        for (String currCnt : counts) {
            int count = Integer.parseInt(currCnt);
            String currStr = concStr.substring(start, start+count);
            res.add(currStr);
            start += count;
        }
        return res;
    }


    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encodeNeetCode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(",");
            sb.append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decodeNeetCode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = str.indexOf(",", i);
            String lenStr = str.substring(i, j);
            int len = Integer.parseInt(lenStr);
            strs.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return strs;
    }
}

