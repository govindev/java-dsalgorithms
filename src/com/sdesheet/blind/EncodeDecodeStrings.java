package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    String END_OF_LENGTHS = "/";
    String COUNT_SEPARATOR = ",";

    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) return null;

        StringBuilder countsSb = new StringBuilder();
        StringBuilder concatenatedSb = new StringBuilder();

        for (String str : strs) {
            countsSb.append(str.length());
            countsSb.append(COUNT_SEPARATOR);

            concatenatedSb.append(str);
        }
        countsSb.append(END_OF_LENGTHS);

        countsSb.append(concatenatedSb);

        return countsSb.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.length() == 0) return new ArrayList<>();

        int countStrEnd = str.indexOf(END_OF_LENGTHS) - 1;
        int strStart = str.indexOf(END_OF_LENGTHS) + 1;

        String countsStr = str.substring(0, countStrEnd);
        String[] countsInStr = countsStr.split(COUNT_SEPARATOR);

        List<String> result = new ArrayList<>();
        for (String countStr : countsInStr) {
            int count = Integer.parseInt(countStr);
            result.add(str.substring(strStart, strStart+count));
            strStart += count;
        }

        return result;
    }
}
