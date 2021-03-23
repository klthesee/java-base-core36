package com.zk;

import com.zk.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test41_Stream_to_collection {

    public static void main(String[] args) {
        Student stu1 = new Student(1, "lbw");
        Student stu2 = new Student(1, "sbyh");
        Student stu3 = new Student(2, "sb2h");
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        Set<Integer> idSet = list.stream().map(Student::getId).collect(Collectors.toSet());
        System.out.println();

    }
}
