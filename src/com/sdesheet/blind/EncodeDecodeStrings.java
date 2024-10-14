package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(",");
            sb.append(str);
        }
        String res = sb.toString();
        return res;
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        int start = 0, end = str.indexOf(",");
        while (end <= str.length()-1) {
            end = str.indexOf(",", start);
            String lenStr = str.substring(start, end);
            int len = Integer.parseInt(lenStr);
            start = end+1;
            end = end+1+len;
            String subStr = str.substring(start, end);
            res.add(subStr);
            start = end;
        }
        return res;
    }
}
