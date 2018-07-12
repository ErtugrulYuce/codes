package com.cybertek;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryStudy {
	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	 @Test
	public void datatestlink() throws InterruptedException {
		driver.get("https://cc.porsche.com/icc_pcna/ccCall.do?rt=1529363919&screen=1920x1080&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='flyout-label-value']")).click();
		Thread.sleep(3000);
		
		String currentUrl= driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	
	
	
}
