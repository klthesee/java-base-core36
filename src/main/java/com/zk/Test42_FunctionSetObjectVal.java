package com.zk;

import com.zk.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Test42_FunctionSetObjectVal {


    public static void main(String[] args) {
        Student student = new Student();
        test(student);
        System.out.println(student);
    }

    public static void test(Student student){
        Student lbw = new Student(1, "lbw");
        Student sb2h = new Student(2, "mff");
        Student bzw = new Student(3, "bzw");
        Student xxbb = new Student(4, "xxbb");
        List<Student> stuList = new ArrayList<>();
        stuList.add(lbw);
        stuList.add(sb2h);
        stuList.add(bzw);
        stuList.add(xxbb);
        student.setStudentList(stuList);
    }
}
