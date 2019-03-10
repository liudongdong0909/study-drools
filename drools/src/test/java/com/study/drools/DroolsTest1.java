package com.study.drools;

import com.study.drools.entity.Order;
import com.study.drools.entity.User;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author walle
 * @version 1.0
 * @create 2019-03-10
 */
public class DroolsTest1 extends DroolsApplicationTests {

    @Test
    public void test1() {
        KieContainer kieContainer = KieServices.Factory.get()
                .getKieClasspathContainer();

        this.execute(kieContainer);

    }

    private void execute(KieContainer kieContainer) {

        KieSession kieSession = kieContainer.newKieSession("test-rule-ksession");
        initData().forEach(order -> {
            kieSession.insert(order);
            kieSession.fireAllRules();
            addScore(order);
        });

        kieSession.dispose();

    }

    private List<Order> initData() {
        List<Order> orderList = new ArrayList<>(4);

        {
            Order order = new Order();
            order.setAmount(80);
            order.setBookingDate(LocalDate.parse("2019-01-01"));
            User user = new User();
            user.setLevel(1);
            user.setName("Name1");
            order.setUser(user);
            order.setScore(111);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmount(200);
            order.setBookingDate(LocalDate.parse("2019-02-01"));
            User user = new User();
            user.setLevel(2);
            user.setName("Name2");
            order.setUser(user);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmount(800);
            order.setBookingDate(LocalDate.parse("2019-03-01"));
            User user = new User();
            user.setLevel(3);
            user.setName("Name3");
            order.setUser(user);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmount(1500);
            order.setBookingDate(LocalDate.parse("2019-04-01"));
            User user = new User();
            user.setLevel(4);
            user.setName("Name4");
            order.setUser(user);
            orderList.add(order);
        }

        return orderList;
    }

    private static void addScore(Order o){
        System.out.println("用户" + o.getUser().getName() + "享受额外增加积分: " + o.getScore());
    }
}
