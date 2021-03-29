package com.zk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/threadpool.properties")
public class ExecutePoolConfig {

//    @Value("")

}
