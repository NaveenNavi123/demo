package test;

import org.testng.annotations.Test;


import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestCase_On_Website {
	WebDriver driver=null;
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NAVEEN GOWDA\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://s1.demo.opensourcecms.com/wordpress/");
		Thread.sleep(1000);
	  }
	 @AfterMethod
	  public void afterMethod() throws InterruptedException {
			Thread.sleep(1000);
			driver.quit();  
	  }
  @Test
  public void TestCase1() throws InterruptedException {
	  String title="opensourcecms – Just another WordPress site";
	  Assert.assertEquals(driver.getTitle(),title);
	  Thread.sleep(1000);
	  System.out.println("We have got a correct title");
  }
  @Test
  public void TestCase2() throws InterruptedException {
	  driver.findElement(By.linkText("WordPress.org")).click();
	  Thread.sleep(2000);
		  String current_url=driver.getCurrentUrl();
		  String expected_url="https://wordpress.org/";

		  Assert.assertEquals(current_url,expected_url);
		  System.out.println("We are in expected webpage");
	 
  }

}
