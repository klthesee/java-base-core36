package com.zk.test;

import com.zk.JavaBaseCore36Application;
import com.zk.Test37_Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaBaseCore36Application.class)
public class Test37 {
    @Autowired
    private Test37_Client test37_client;
    @Test
    public void test01() {
        test37_client.test01();
    }
}
