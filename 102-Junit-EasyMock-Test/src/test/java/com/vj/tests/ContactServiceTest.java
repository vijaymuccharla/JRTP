package com.vj.tests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.vj.dao.IContactDao;
import com.vj.exceptions.NoDataFoundException;
import com.vj.model.Contact;
import com.vj.services.ContactServiceImpl;

public class ContactServiceTest {

	private static ContactServiceImpl service;
	private static IContactDao proxyDao;
	
	public ContactServiceTest() {
		System.out.println("ContactServiceTest.ContactServiceTest()");
	}

	@BeforeClass
	public static void init() {
		
		System.out.println("ContactServiceTest.init()");
		
		//creating Contact Obj to return this data when findContactById() method on DAO
		Contact contact=new Contact();
		contact.setContactId(111);
		contact.setContactName("maria");
		contact.setContactAddrs("HYD");

//________________________________________________________________
		//setting temp names for DAO to return all names when findAllNames() called
		List<String> names=new ArrayList();
		names.add("John");
		names.add("Sean");
		names.add("Sam");
		names.add("Tina");
		
//________________________________________________________________

		//Creating Proxy obj for DAO
		proxyDao=EasyMock.createMock(IContactDao.class);

//________________________________________________________________
		//set behaviours for proxy
		EasyMock.expect(proxyDao.findNameById(777))
				.andReturn("Vijay");
		EasyMock.expect(proxyDao.findNameById(666))
				.andReturn("Mani");
//________________________________________________________________
		//behaviour for proxy when findAllNames() called on proxyDao
		EasyMock.expect(proxyDao.findAllNames())
		.andReturn(names);
//________________________________________________________________
		//behaviour for proxy when findContactByContactById() called on proxyDao

		EasyMock.expect(proxyDao.findContactByContactId(111))
				.andReturn(contact);
		EasyMock.expect(proxyDao.findContactByContactId(222))
				.andReturn(null);
//________________________________________________________________

		//repeat the behaviour
		EasyMock.replay(proxyDao);

//________________________________________________________________
		//service obj
		service= new ContactServiceImpl();
		//setter injection of proxyDao to ContactServiceImpl setter metthod
		service.setDao(proxyDao);

	}

	@Test
	public void testGetNameById_01() {
		System.out.println("ContactServiceTest.testGetNameById_01()");
		String name = service.getNameById(666);
		System.out.println(name);
		assertNotNull(name);
	}

	@Test
	public void testGetAllNames_01() {
		System.out.println("ContactServiceTest.testGetAllNames_01()");
		List<String> names=service.getAllNames();
		for (String name : names) {
			System.out.println(name);
		}
		assertNotNull(names);
	}

	@Test(expected = NoDataFoundException.class)
	public void testGetContactById_01(){
		System.out.println("ContactServiceTest.testGetContactById_01()");
		 service.getContactById(222);
	}
	
	@Test
	public void testGetContactById_02(){
		System.out.println("ContactServiceTest.testGetContactById_02()");
		 service.getContactById(111);
	}

	@AfterClass
	public static void destroy() {
		System.out.println("ContactServiceTest.destroy()");
		proxyDao=null;
		service=null;
	}

}
