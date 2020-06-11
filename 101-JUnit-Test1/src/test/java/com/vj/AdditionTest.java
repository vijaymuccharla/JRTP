package com.vj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditionTest {

	@Test
	public void testAdd_1() {
		Addition add=new Addition();
		
		int actualResult= add.add(100, 200);
		int expectedResult= 300;
		
		assertEquals(expectedResult, actualResult);
	}
	
	
}
