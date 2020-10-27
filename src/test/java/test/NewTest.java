package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver=null;
	@BeforeMethod
	  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NAVEEN GOWDA\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }
	 @AfterMethod
	  public void afterMethod() throws InterruptedException {
			Thread.sleep(1000);
			driver.quit();  
	  }
  @Test
  public void f() {
	  //driver.get("http://www.google.com"); 
	  driver.get("http://www.google.com");
	  System.out.println(driver.getTitle());
  }
  
 

}
