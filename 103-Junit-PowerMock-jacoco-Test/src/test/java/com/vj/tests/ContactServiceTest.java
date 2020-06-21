package com.vj.tests;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.vj.dao.IContactDao;
import com.vj.exceptions.NoDataFoundException;
import com.vj.model.Contact;
import com.vj.services.ContactServiceImpl;

public class ContactServiceTest {

	private static ContactServiceImpl service1;
	private static IContactDao proxyDao1;

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
		proxyDao1=mock(IContactDao.class);

		//________________________________________________________________
		//set behaviours for proxy
		when(proxyDao1.findNameById(777))
		.thenReturn("Vijay");
		when(proxyDao1.findNameById(666))
		.thenReturn("Mani");
		//________________________________________________________________
		//behaviour for proxy when findAllNames() called on proxyDao
		when(proxyDao1.findAllNames())
		.thenReturn(names);
		
		when(proxyDao1.findAllNames())
		.thenReturn(null);
		

		//________________________________________________________________
		//behaviour for proxy when findContactByContactById() called on proxyDao

		when(proxyDao1.findContactByContactId(111))
		.thenReturn(contact);
		when(proxyDao1.findContactByContactId(222))
		.thenReturn(null);
		//________________________________________________________________

		//________________________________________________________________
		//service obj
		service1= new ContactServiceImpl();
		//setter injection of proxyDao to ContactServiceImpl setter metthod
		service1.setDao(proxyDao1);

	}

	@Test
	//	@Ignore
	public void testGetNameById_01() {
		System.out.println("ContactServiceTest.testGetNameById_01()");
		String name = service1.getNameById(666);
		System.out.println(name);
		assertNotNull(name);
	}

	@Test
	@Ignore
	public void testGetAllNames_01() {
		System.out.println("ContactServiceTest.testGetAllNames_01()");
		List<String> names=service1.getAllNames();
		for (String name : names) {
			System.out.println(name);
		}
		assertNotNull(names);
	}

	@Test(expected = NullPointerException.class)
	public void testGetAllNames_02() {
		System.out.println("ContactServiceTest.testGetAllNames_01()");
		List<String> names=service1.getAllNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test(expected = NoDataFoundException.class)
	//	@Ignore
	public void testGetContactById_01(){
		System.out.println("ContactServiceTest.testGetContactById_01()");
		service1.getContactById(222);
	}

	@Test
	//	@Ignore
	public void testGetContactById_02(){
		System.out.println("ContactServiceTest.testGetContactById_02()");
		service1.getContactById(111);
	}

	@AfterClass
	public static void destroy() {
		System.out.println("ContactServiceTest.destroy()");
		proxyDao1=null;
		service1=null;
	}

}
