package com.zk;

public class Test43_static {

    static void test(){
        System.out.println("static");
    }

    public static void main(String[] args) {
        Test43_static test41_static = new Test43_static();
        test();
        // 实例不能调用静态方法，所以autowired不能注入
//        test41_static.test(); error

    }

    /**
     * 1.
     * 如果要在静态方法中调用某一bean的方法，那么该bean必须声明为static的，但正常情况下@Autowired无法注入静态的bean,。
     * 利用Spring的使用SpringContextHolder工具类的getBean方法来获取静态bean。
     *
     * 2.本身不是bean，--》所以不能自动注入。需要用SpringContextHolder获取容器中的bean
     */
}
