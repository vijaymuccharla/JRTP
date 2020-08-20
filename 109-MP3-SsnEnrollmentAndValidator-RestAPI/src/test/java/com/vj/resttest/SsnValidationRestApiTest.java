package com.vj.resttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.h2.command.dml.MergeUsing.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vj.rest.SsnValidationRestController;
import com.vj.services.SsaService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnValidationRestController.class)
public class SsnValidationRestApiTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SsaService service;
	
	@Test
	public void ssnIsEnrolledOrNotTest_01() throws Exception {
		when(service.ssnEnrolledOrNot(1234l, "NY")).thenReturn("VALID");
		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/validateSsn/12345/NY");
		MvcResult result = mockMvc.perform(getReq).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println("Response Result is : "+response.getContentAsString());
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void ssnIsEnrolledOrNotTest_02() throws Exception {
		when(service.ssnEnrolledOrNot(5678l, "NY")).thenReturn("IN-VALID");
		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/validateSsn/5678/NY");
		MvcResult result = mockMvc.perform(getReq).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String respRes=response.getContentAsString();
		System.out.println("Response Result is : "+respRes);
		assertEquals("IN-VALID", respRes);
	}

}
