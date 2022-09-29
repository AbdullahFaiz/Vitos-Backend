package com.synergen.vitos;

import com.synergen.vitos.controller.UserController;
import com.synergen.vitos.dto.UserResponse;
import com.synergen.vitos.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
class VitosApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserController userController;

	@Test
	void createUserTest(){
		User user = new User();
		user.setContactNo("077558798");
		user.setPassword("123");
		user.setName("Saadiq");
		user.setAddress("Kandy");
		user.setEmail("DEA");

		UserResponse userResponse = new UserResponse();
		userResponse = userController.createUser(user);

		Assert.assertEquals(userResponse.getRegUser().getName(), user.getName());

	}
}
