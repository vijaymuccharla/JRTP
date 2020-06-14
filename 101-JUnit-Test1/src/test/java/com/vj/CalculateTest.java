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

@Test : To represent method as Junit method

@BeforeClass    : To execute method before first test case execution

@AfterClass : To execute method after last test case execution

@Ignore : To skip method from current execution

-> For business class methods we are going to write Junit methods

-> For one business method we can write multiple unit  test methods

-> When we are performing Unit testing, sometime we need to except Exceptions from target class method.

-> When we are expecting an exception, we will use "expected" attribute in @Test annoation

ex : 	@Test(expected = ArithmeticException.class)
		public void testDiv_02() {
		calc.div(10, 0);
		}

-> We can use timeout attribute in @Test annotation

-> timeout attribute is used check target method execution completing within given amount of time or not

-> If target method execution is taking more time than given value then then it will be terminated abnormally


ex : 		@Test(timeout = 1000)
			public void testDiv_03() {
			calc.div(10, 2);
			}
 */




public class CalculateTest {

	private static Calculate calc;


	public CalculateTest() {
		System.out.println("Test : 0 param");
	}


	@BeforeClass		//calls this method before testing any test cases
	public static void init() {
		System.out.println("Before Class");
		calc=new Calculate();		//business/target class instantiation, to avoid boiler code
	}

	@Test		//to include this method in testing
	@Ignore 	//exclude/ignore from testing (this overrides @Test operation)
	public void testAdd_01() {
		int actualResult= calc.add(100, 200);
		int expectedResult= 300;
		assertEquals(expectedResult, actualResult);
	}
	@Test		//to include this method in testing
	@Ignore 	//exclude/ignore from testing (this overrides @Test operation)
	public void testAdd_02() {
		int actual=calc.add(10, 39);
		int expected= 49;
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	//	public static void testSubstract_03(){		//EXCEPTION : cannot instantiate static
	public void testSubstract_01(){
		int actual=calc.substract(100, 50);
		int expected=50;
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testSubstract_02(){
		int actual=calc.substract(50, 100);
		int expected=-50;
		assertEquals(expected, actual);
	}

	//when expecting any exception, mention in expected attribute of @Test
	@Test(expected = ArithmeticException.class)		
	@Ignore
	public void testDevide_01() {
		calc.divide(10, 0);			//Arithmetic Exception
	}

	@Test(timeout = 1000)	//timeout attribute used to set limit of time for the method to execute
	public void testDevide_02() throws InterruptedException {
		Thread.sleep(1005);		//pausing execution on purpose for testing 'timeout' attribute
		assertEquals(2, calc.divide(20, 10));
	}


	@AfterClass		//to run this method after all test cases are executed
	public static void destroy() {
		System.out.println("After class");
		calc=null;		//nullifying
	}

}
