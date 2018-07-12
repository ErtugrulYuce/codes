package com.cybertek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@BeforeClass  // run one time before everything 
	public void setUpClass() {
		System.out.println("run one time before everything");
	}
	@BeforeMethod  // run before every methods
	public void setUpMethod() {
		System.out.println("runs before everytime methods");
	}
	
	
	//@Ignore   // ignore right after test case
	@Test
	public void testOne() {
		System.out.println("First one");
	}
	
	@Test
	public void testSecond(){
		System.out.println("second one");
	}
	
	@AfterMethod // run after every method 
	public void tearDownMethod() {
		System.out.println("runs after everytime methods");
	}
	
	@AfterClass // run one time after everything 
	public void tearDownClass() {
		System.out.println("run one time after everything");
	}
}
