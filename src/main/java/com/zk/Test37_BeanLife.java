package com.zk;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Aware 注入的意思
 * ApplicationContextAware：注入ApplicationContext当前实例中,
 * 主要作用是可以作为工具类获取bean。在不是bean的类中使用获取其他bean。
 * 通过new A。在其他bean使用这个实例a, A中使用实现ApplicationContext的工具类获取bean
 * BeanNameAware：
 */
@Component
public class Test37_BeanLife {


    public Test37_BeanLife() {
        System.out.println("构造方法");

    }

    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    @PostConstruct()
    public void init() {
        System.out.println("bean init()");
    }
}
