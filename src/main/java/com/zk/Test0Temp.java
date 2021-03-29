package com.zk;

import java.util.*;

public class Test0Temp {
    public Map<String, List<String>> map = new HashMap<>();
    public String state = "start";


    public int myAtoi(String s) {
        /**
         * state    遇到空         符号          数字            其他
         * start :  start,          signed，     in_num,        end
         * signed :  end            end         in_num          end
         * 数字 :     end           end           in_num         end
         * end :     end            end           end           end
         *
         * 根据上一个状态获取到当前状态state，更新state。根据state进行相应操作。如果state是数字进行累加，符号取符号状态
         */
        List<String> l0 = Arrays.asList("start", "signed", "in_num", "end");
        List<String> l1 = Arrays.asList("end", "end", "in_num", "end");
        List<String> l2 = Arrays.asList("end", "end", "in_num", "end");
        List<String> l3 = Arrays.asList("end", "end", "end", "end");
        map.put("start",l0);
        map.put("signed",l1);
        map.put("in_num",l2);
        map.put("end",l3);

        long ans=0;
        int isNag = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            state = getState(c);
            if (state == "in_num") {
                int mNum = c - '0';
                ans = ans*10;
                ans += mNum;
//                System.out.println( mNum+"    "+ans);
            } else if (state == "signed") {
                if (c=='-'){
                    isNag = 1;
                } else if (c == '+') {
                    isNag = 0;
                }
            }
        }
        if (isNag == 1) {
            ans *= -1;
        }
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)ans;
    }

    public String getState(char c) {
        List<String> list = map.get(state);
        boolean isC = isCap(c);
        int t = 0;
        if (!isC) {
            if (c == '-' || c == '+') {
                t = 1;
            } else if ((c - '0') <= 9 && (c - '0') >= 0) {
                t = 2;
            } else {
                t = 3;
            }
        }
        String curState =  list.get(t);
        return curState;
    }

    public boolean isCap(char c) {
        if (c == ' ') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Test0Temp t = new Test0Temp();
//        int res = t.myAtoi("-110");
        int res = t.myAtoi("9223372036854775808");
        System.out.println(res);
    }
}
