package com.zk;

public class Test23_Classload {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader sysClassLoader = Test23_Classload.class.getClassLoader();
        System.out.println(sysClassLoader);

        ClassLoader extClassLoader = sysClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        // 双亲委派只是一个算法，不是强制要求
        Class<?> aClass = sysClassLoader.loadClass("java.lang.Integer");
        System.out.println(aClass);
    }

    /**
     * 自定义类加载器，
     * 第三方公司为包装程序安全会对类型进行加密，只有用他们公司的类加载器才能解密并加载这个类
     */

}
