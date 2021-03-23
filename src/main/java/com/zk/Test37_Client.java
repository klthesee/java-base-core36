package com.zk;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Lazy(false)
public class Test37_Client implements BeanPostProcessor {
//    private Test37_NotBean test37_notBean;
    public void test01() {
        Test37_NotBean test37_notBean = new Test37_NotBean();
        System.out.println("-----");
        test37_notBean.useBean();
    }

//    @PostConstruct
//    public void createnewBean(){
//        test37_notBean = new Test37_NotBean();
//    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("lbw postProcessBeforeInitialization");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        test37_notBean.useBean();
        System.out.println("lbw postProcessAfterInitialization");

        return null;
    }

}
