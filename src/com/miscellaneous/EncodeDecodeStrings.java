package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = List.of("lint", "code", "love", "you");
        String encoded = encodeBetter(strs);
        System.out.println("encoded string : " + encoded);
        List<String> decodedStrs = decodeBetter(encoded);
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

        String concStr = str.substring(sepOcc+1, str.length());

        int start = 0;
        for (String currCnt : counts) {
            int count = Integer.parseInt(currCnt);
            String currStr = concStr.substring(start, start+count);
            res.add(currStr);
            start += count;
        }
        return res;
    }


    public String encodeLastTried(List<String> strs) {
        StringBuilder sb = new StringBuilder().append("<size>").append(strs.size()).append("</size>").append("<lengths>");
        StringBuilder sumStr = new StringBuilder();

        for (String str : strs) {
            sumStr.append(str);
            sb.append(str.length()).append(",");
        }

        sb.deleteCharAt(sb.length() - 1); // Remove the last comma
        sb.append("</lengths>");
        sb.append(sumStr.toString());

        return sb.toString();
    }

    public List<String> decodeLastTried(String str) {
        // Extract the size
        String sizeStr = str.substring(str.indexOf("<size>") + 6, str.indexOf("</size>"));
        Integer size = Integer.parseInt(sizeStr);
        if (size == 0) return new ArrayList<>();

        // Extract the lengths
        String lengthsStr = str.substring(str.indexOf("<lengths>") + 9, str.indexOf("</lengths>"));
        String[] lengths = lengthsStr.split(",");

        // Extract the concatenated strings
        String sumStr = str.substring(str.indexOf("</lengths>") + 10);

        // Decode the original strings
        List<String> strings = new ArrayList<>();
        int previousEnd = 0;
        for (int i = 0; i < size; i++) {
            int length = Integer.parseInt(lengths[i]);
            String res = sumStr.substring(previousEnd, previousEnd + length);
            previousEnd += length;
            strings.add(res);
        }

        return strings;
    }

}
