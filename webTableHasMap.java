package mentorings.auto;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webTableHasMap {
	WebDriver driver;
	Map<String, String> table;
	List<WebElement> listVal1;
	List<WebElement> listVal2;
	List<WebElement> listVal3;
	List<WebElement> key;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
	}

	@Test
	public void testCases() throws InterruptedException {

		table = new HashMap<String, String>();

		driver.findElement(By.xpath("//select[@id='recPerPage']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'100')]")).click();
		Thread.sleep(2000);
		
		key = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[1]"));
		listVal1 = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[2]"));
		listVal2 = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[3]"));
		listVal3 = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[4]"));
		addToTable();

		driver.findElement(By.xpath("//a[@class='nxtArrow']")).click();
		Thread.sleep(2000);
		
		key = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[1]"));
		listVal1 = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[2]"));
		listVal2 = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[3]"));
		listVal3 = driver.findElements(By.xpath("//table[@id='reportTab']//tbody//tr//td[4]"));
		
		addToTable();
		int numberOfElement = Integer.parseInt(driver.findElement(By.xpath("//span[@id='total']")).getText());
		//System.out.println(numberOfElement);
		int numberOfRowTable = table.keySet().size();
		//System.out.println(numberOfRowTable);
		
		
		assertEquals(numberOfRowTable, numberOfElement);

		//System.out.println(table);

	}

	@AfterClass
	public void tearDownClass() throws InterruptedException {
		Thread.sleep(500);
		driver.close();
	}

	private void addToTable() {
		
		for (int i = 0; i < key.size(); i++) {
			table.put(key.get(i).getText(),
					listVal1.get(i).getText() + "-" + listVal2.get(i).getText() + "-" + listVal3.get(i).getText());
			 System.out.println(key.get(i).getText()+" : "+ listVal1.get(i).getText()
			 +"-"+ listVal2.get(i).getText() +"-"+ listVal3.get(i).getText());
		}
	}
}