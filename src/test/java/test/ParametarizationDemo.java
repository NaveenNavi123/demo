package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ParametarizationDemo {
	WebDriver driver=null;
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NAVEEN GOWDA\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
	  }
	 @AfterMethod
	  public void afterMethod() throws InterruptedException {
			Thread.sleep(1000);
			driver.quit();  
	  }
  @Test
  public void f() throws IOException, InterruptedException {
	  String filepath="C:\\Users\\NAVEEN GOWDA\\Desktop\\para.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wbook.getSheet("Sheet1");
		int rows=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		
		for(int i=1;i<=rows;i++) {
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.id("email")).sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.id("passwd")).sendKeys(sheet1.getRow(i).getCell(1).getRawValue());
			driver.findElement(By.id("SubmitLogin")).click();
			
			
			Thread.sleep(3000);
			try {
				SoftAssert sa=new SoftAssert();
				sa.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
				driver.findElement(By.linkText("Sign out")).click();
				System.out.println("Successfully logged in and logged out");
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li")).getText());
			}
		}
		wbook.close();
  }
}
