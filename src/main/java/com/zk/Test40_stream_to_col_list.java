package com.zk;

import com.zk.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 删除list中元素
 */
public class Test40_stream_to_col_list {

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
        int len = list.size();
        for (int i = len - 1; i >= 0; i--) {

            if (list.get(i) % 2 != 1) {
                list.remove(i);
            }
        }
/*
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            if (val%2 !=1) {
                it.remove();
            }
        }
*/

        Student lbw = new Student(1, "lbw");
        Student sb2h = new Student(2, "mff");
        Student bzw = new Student(3, "bzw");
        Student xxbb = new Student(4, "xxbb");
        List<Student> stuList = new ArrayList<>();
        stuList.add(lbw);
        stuList.add(sb2h);
        stuList.add(bzw);
        stuList.add(xxbb);
        List<Integer> idList = stuList.stream().map(Student::getId).collect(Collectors.toList());
        Iterator<Integer> iterator = idList.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val % 2 != 1) {
                iterator.remove();
            }
        }
        System.out.println();
    }


}
