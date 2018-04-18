package com.lookthings.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Fantasy on 2018/4/19.
 *
 * @author Fantasy
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-mvc.xml"})
public class BaseTest {
    @Test
    public void MainTest(){
        System.out.println("initTest");
    }
}
