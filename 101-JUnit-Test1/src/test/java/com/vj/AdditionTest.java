package com.vj;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



/*

--> Junit is an open source framework
--> Junit is used to perform unit testing for java apps
--> We have annotations in junit to perform UT
--> We have Assertions in JUnit to validate results

Annotations
-----------
@Test : It is used to represent java method as a JUnit method

-> For one business method we can write multiple unit test methods

@BeforeClass & @AfterClass
---------------------------
-> These two are method level annotations

-> @BeforeClass annotated method will execute before first test case (I will create target class obj here)

-> @AfterClass annotated method will execute after last test case (I will nullify target class obj here)

*/




public class AdditionTest {

	private static Addition add;

	@BeforeClass		//calls this method before testing any test cases
	public static void init() {
		add=new Addition();		//business/target class instantiation, to avoid boiler code
	}

	@Test		//to include this method in testing
	@Ignore 	//exclude/ignore from testing (this overrides @Test operation)
	public void testAdd_01() {
		int actualResult= add.add(100, 200);
		int expectedResult= 300;
		assertEquals(expectedResult, actualResult);
	}
	@Test		//to include this method in testing
	@Ignore 	//exclude/ignore from testing (this overrides @Test operation)
	public void testAdd_02() {
		int actual=add.add(10, 39);
		int expected= 49;
		assertEquals(expected, actual);
	}

	@Test
	//	public static void testSubstract_03(){		//EXCEPTION : cannot instantiate static
	public static void testSubstract_03(){
		int actual=add.substract(100, 50);
		int expected=50;
		assertEquals(expected, actual);
	}

	@Test
	public void testSubstract_04(){
		int actual=add.substract(50, 100);
		int expected=-50;
		assertEquals(expected, actual);
	}

	@AfterClass		//to run this method after all test cases are executed
	public static void destroy() {
		add=null;		//nullifying
	}

}
