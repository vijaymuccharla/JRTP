package com.vj.tests;

import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vj.dao.IContactDao;
import com.vj.services.ContactServiceImpl;
import com.vj.services.IContactService;

public class ContactServiceTest {
	@Test
	public void testGetNameById_01() {
		
		//Creating Proxy obj for DAO
		IContactDao daoProxy=EasyMock.createMock(IContactDao.class);
		
		//set behaviour for proxy
		EasyMock.expect(daoProxy.findNameById(777)).andReturn("Vijay");
		EasyMock.expect(daoProxy.findNameById(666)).andReturn("Mani");
		//repeat the behaviour
		EasyMock.replay(daoProxy);
		
		ContactServiceImpl contactService= new ContactServiceImpl();
		contactService.setDao(daoProxy);	//service using mock obj we created using EasyMock
		String name = contactService.getNameById(666);
		System.out.println(name);
		assertNotNull(name);
	}
	
}
