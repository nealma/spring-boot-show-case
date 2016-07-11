package com.nealma.repository;

import com.nealma.Application;
import com.nealma.domain.User;
import com.nealma.domain.Order;
import com.nealma.repository.secondary.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nealpc on 7/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class OrderTest {

    @Autowired
    com.nealma.repository.primary.UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
        // 创建10条记录
        User user;
        for (int e = 0; e < 10; e++) {
            user = new User();
            user.setAge(e);
            user.setName("name");
            user.setLevel(e);
            userRepository.save(user);
        }

        Order userSecondary1;
        for (int e = 0; e < 10; e++) {
            userSecondary1 = new Order();
            userSecondary1.setAge(e);
            userSecondary1.setName("name");
            userSecondary1.setLevel(e);
            orderRepository.save(userSecondary1);
        }
    }


}
