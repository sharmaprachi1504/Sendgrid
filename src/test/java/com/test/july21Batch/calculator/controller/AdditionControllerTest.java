package com.test.july21Batch.calculator.controller;

import static org.junit.Assert.*;
import org.junit.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionControllerTest {
	private AdditionController objCalcUnderTest;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		objCalcUnderTest = new AdditionController();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		System.out.println("Success");
	}

	@Test
	public void testSum() {
		int a = 15; int b = 20; 
		int expectedResult = 35;
		//Act 
		long result = objCalcUnderTest.sum(a, b);
		//Assert
		Assert.assertEquals(expectedResult, result);	
	}

	@Test
	public void testSubstract() {
		int a = 25; int b = 20; 
		int expectedResult = 5; 
		long result = objCalcUnderTest.substract(a, b);
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testMultiply() {
		int a = 10; int b = 25;
		long expectedResult = 250;
		long result = objCalcUnderTest.multiply(a, b);
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testDivide() {
		int a = 100; int b = 10; 
		double expectedResult = 10.0; 
		double result = objCalcUnderTest.divide(a, b);
		Assert.assertEquals(expectedResult, result,0.00005);
	}

}
