package org.jfaster.test;

import org.jfaster.test.service.DriverOrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试启动类
 * @author yanpengfang
 * @create 2019-02-13 10:08 AM
 */
public class TestMain {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
       DriverOrderService orderService  = context.getBean(DriverOrderService.class);
       orderService.deleteDriverAndOrder(16, "P224378961549867525895");
    }
}
