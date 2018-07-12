package com.cybertek;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownMenu {

	public static void main(String[] args) {
		// https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", 
//				"C:\\Users\\Asus\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String url = "https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/";
		driver.get(url);
		
		// first select tag
		WebElement selectTag= driver.findElement(By.name("my_html_select_box"));
		// second select object from select tag
		Select list= new Select(selectTag);
		// getFirstSelectedOption()--> it selects first drop down value
		// print the selected value: option 1
//        list.getFirstSelectedOption();
        WebElement selected = list.getFirstSelectedOption();
        System.out.println(selected.getText());
        System.out.println(list.getFirstSelectedOption().getText());
        //print all the available options
        // returns a list of all the options(selected and not selected everything
        
        List<WebElement> options = list.getOptions();
        System.out.println("------------");
       for (WebElement webElement : options) {
		System.out.println(webElement.getText());
	}
       System.out.println("----------------");
        // select using the visible text
       list.selectByVisibleText("Bucharest");
       System.out.println("selected: "+ list.getFirstSelectedOption().getText());
       // select using the index
       // count starts from 0
       list.selectByIndex(2);
       System.out.println("selected: "+list.getFirstSelectedOption().getText());
       // select using value
       // list.selectedByValue("jhgfds");
       
       System.out.println("*********************");
       
       Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
       secondList.deselectByVisibleText("New York");
       secondList.deselectByVisibleText("Madrid");
       List<WebElement> allSelectedOptions = secondList.getAllSelectedOptions();
       
       for (WebElement webElement :allSelectedOptions ) {
		System.out.println(webElement.getText());
	}
       System.out.println(allSelectedOptions.size());
       secondList.deselectAll();
       System.out.println(allSelectedOptions.size());
	}

}