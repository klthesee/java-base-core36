package com.zk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test37 {



    public static void main(String[] args) {
        Integer[] a = {1,2,3,4};
        List<Integer> list1 = Arrays.asList(a);
        List<Integer> list = list1.subList(2, 4);
        list.set(0, 9);
        System.out.println();

    }
}
