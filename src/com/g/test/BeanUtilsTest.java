package com.g.test;

import com.g.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;


class BeanUtilsTest {

    /**
     * 测试BeanUtils方法，操作的是属性：
     * getUsername() --> Username --> username
     * lalala --> Lalala --> setLalala()
     */
    @Test
    void Test() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "username", "zhangsan");
            System.out.println(user);//User{id=0, username='zhangsan', password='null'}

            String lalala = BeanUtils.getProperty(user, "lalala");
            System.out.println(lalala);//zhangsan

            BeanUtils.setProperty(user,"lalala","lisi");
            System.out.println(user);//User{id=0, username='lisi', password='null'}
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

