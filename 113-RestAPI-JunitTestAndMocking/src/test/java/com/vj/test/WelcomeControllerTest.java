package com.vj.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vj.rest.WelcomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WelcomeController.class)
public class WelcomeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void welcomeUserTest() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/user/VijayMuccharla");
		MvcResult result = mockMvc.perform(request).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println("Response from API : "+response.getContentAsString());
		assertEquals(200, response.getStatus());
	}
}
