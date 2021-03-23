package com.zk;

public class Test37_NotBean {

    private Test37_BeanA test37_BeanA;

    public Test37_NotBean() {
        test37_BeanA = Test37_ApplicationContextUtil.getBean(Test37_BeanA.class);
    }

    public void useBean() {
        String str = test37_BeanA.getStr();
        System.out.println("Test37_NotBean useBean -- "+ str);
    }

}
