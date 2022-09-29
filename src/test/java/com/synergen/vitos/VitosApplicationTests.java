package com.synergen.vitos;

import com.synergen.vitos.controller.CategoryController;
import com.synergen.vitos.controller.UserController;
import com.synergen.vitos.dto.CategoryResponse;
import com.synergen.vitos.dto.UserResponse;
import com.synergen.vitos.enums.RecordStatusEnum;
import com.synergen.vitos.model.Category;
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

	@Autowired
	CategoryController categoryController;

	@Test
	void createUserTest(){
		User user = new User();
		user.setContactNo("0775587978");
		user.setPassword("123");
		user.setName("Saadiq");
		user.setAddress("Kandy");
		user.setEmail("DEA");

		UserResponse userResponse = userController.createUser(user);

		Assert.assertEquals(userResponse.getRegUser().getName(), user.getName());
		Assert.assertEquals(userResponse.getRegUser().getContactNo(), user.getContactNo());
		Assert.assertEquals(userResponse.getRegUser().getEmail(), user.getEmail());
		Assert.assertEquals(userResponse.getRegUser().getAddress(), user.getAddress());

	}

	@Test
	void createCategoryTest(){
		Category category = new Category();
		category.setCode("MXC");
		category.setDescription("Mexican Pizza");
		category.setStatus(RecordStatusEnum.ACTIVE.getCode());

		CategoryResponse categoryResponse = categoryController.createCategory(category);

		Assert.assertEquals(categoryResponse.getCreatedCategory().getCode(), category.getCode());
		Assert.assertEquals(categoryResponse.getCreatedCategory().getDescription(), category.getDescription());
		Assert.assertEquals(categoryResponse.getCreatedCategory().getStatus(), category.getStatus());


	}
}
