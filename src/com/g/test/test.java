package com.g.test;

import com.g.dao.UserDao;
import com.g.domain.User;
import org.junit.jupiter.api.Test;

class test {

    @Test
    void testLogin() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");

        UserDao dao = new UserDao();
        user = dao.login(user);
        System.out.println(user);
    }
}
