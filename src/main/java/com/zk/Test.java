package com.zk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    /**
     * 	         ' '	   +/-	  number	other
     * start	 start	signed	in_number	end
     * signed	 end	end	    in_number	end
     * in_number end	end	    in_number	end
     * end	    end	    end	    end	        end
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        Map<String, String[]> map = new HashMap<>();
        map.put("start", new String[]{"start", "signed", "in_num", "end"});
        map.put("signed",new String[]{"end","end","in_num","end"});
        map.put("in_num", new String[]{"end", "end", "in_num", "end"});
        map.put("end", new String[]{"end", "end", "end", "end"});
        for (int i = 1; i < s.length(); i++) {

            String[] strs = map.get("lastSate");
            List<String> strings = Arrays.asList(strs);

        }
        return 0;
    }

    /**
     * 获取当前状态
     * @param c
     * @return
     */
    public String getState(char c) {
        int k = c - '0';
        String cur = "";
        if (c == ' ') {
            cur = "start";
        } else if (c == '-' || c == '+') {
            cur = "signed";
        } else if (k <= 9 && k >= 0) {
            cur = "in_num";
        } else {
            cur = "end";
        }
        return cur;
    }

    public static void main(String[] args) {
        long input =  Integer.MAX_VALUE + 1;
        String s = String.valueOf("+-12");
        int res = myAtoi(s);
        System.out.println(res);
    }

}
