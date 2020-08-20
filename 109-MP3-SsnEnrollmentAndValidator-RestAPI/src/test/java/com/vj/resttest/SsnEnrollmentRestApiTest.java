package com.vj.resttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vj.model.SsnEnrollmentRequest;
import com.vj.rest.SsnEnrollmentRestController;
import com.vj.services.SsaService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnEnrollmentRestController.class)
public class SsnEnrollmentRestApiTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SsaService service;
	
	@Test
	public void enrollReqTest_01() throws Exception {
		when(service.ssnEnrollment(Mockito.any(SsnEnrollmentRequest.class)))
					.thenReturn(763546277l);
		SsnEnrollmentRequest newCitizen=new SsnEnrollmentRequest();
		newCitizen.setFirstName("Vijay");
		newCitizen.setLastName("Muccharla");
		newCitizen.setDob(new Date(1994/8/13));
		newCitizen.setGender("Male");
		newCitizen.setStateName("NY");
		
		ObjectMapper mapper=new ObjectMapper();
		String reqJson = mapper.writeValueAsString(newCitizen);
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/enrollSsn")
						.contentType(MediaType.APPLICATION_JSON)
						.content(reqJson);
		
		MvcResult result = mockMvc.perform(req).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String respResult = response.getContentAsString();
		System.out.println("Test1 response result : "+respResult);
		System.out.println(respResult);
		
		assertEquals(201, response.getStatus());
		
	}
	@Test
	public void enrollReqTest_02() throws Exception {
		when(service.ssnEnrollment(Mockito.any(SsnEnrollmentRequest.class)))
		.thenReturn(123456789l);
		SsnEnrollmentRequest newCitizen=new SsnEnrollmentRequest();
		newCitizen.setFirstName("Vijay");
		newCitizen.setLastName("Muccharla");
		newCitizen.setDob(new Date(1994/8/13));
		newCitizen.setGender("Male");
		newCitizen.setStateName("NY");
		
		ObjectMapper mapper=new ObjectMapper();
		String reqJson = mapper.writeValueAsString(newCitizen);
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/enrollSsn")
				.contentType(MediaType.APPLICATION_JSON)
				.content(reqJson);
		
		MvcResult result = mockMvc.perform(req).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String respResult = response.getContentAsString();
		System.out.println("Response result is : "+respResult);
		String expected="Enrollmet Success, your SSN :: 123456789";
		assertEquals(expected, respResult);
		
	}
}
