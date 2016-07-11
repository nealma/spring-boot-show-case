package com.nealma.repository;

import com.google.gson.Gson;
import com.nealma.Application;
import com.nealma.domain.User;
import com.nealma.repository.primary.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nealpc on 7/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserTest {

    @Autowired
    UserRepository userRepository;

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

        //更新
        user = userRepository.findOne(1L);
        user.setAge(111);
        userRepository.save(user);

        //分页
        int page = 0;
        int size = 2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> userPage = userRepository.findAll(1, pageable);
        System.out.println(" page " + new Gson().toJson(userPage.getContent()));


//        // 测试findAll, 查询所有记录
//        Assert.assertEquals(10, userRepository.findAll().size());
//
//        // 测试findByName, 查询姓名为FFF的User
//        Assert.assertEquals(1, userRepository.findByName("name1").getAge().longValue());
//
//        // 测试findUser, 查询姓名为FFF的User
//        Assert.assertEquals(1, userRepository.findUser("name1").getAge().longValue());
//
//        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
//        Assert.assertEquals("name1", userRepository.findByNameAndAge("name1", 1).getName());

        // 测试删除姓名为AAA的User
//        userRepository.delete(userRepository.findByName("name1"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
//        Assert.assertEquals(9, userRepository.findAll().size());

    }


}
