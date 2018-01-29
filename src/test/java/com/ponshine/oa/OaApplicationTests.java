package com.ponshine.oa;


import com.ponshine.oa.user.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ponshine.oa.user.dao.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {
	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private CareRepository careRepository;

	@Test
	public void test() throws Exception {
        User user = new User();
        user.setUserId(2L);
        user.setEmail("122@qq.com");
        user.setPassword("123");
        userRepository.save(user);
        User user1 = userRepository.findByEmailAndPassword("122@qq.com", "123");
        //User user1 = userRepository.findByEmailAndPassword("122@qq.com","123");
        Assert.assertEquals("122@qq.com", user1.getEmail());

	}

	@Test
	public void contextLoads() {

	}

}
