package Pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class main {
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NAVEEN GOWDA\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = "http://automationpractice.com/index.php";
		driver.get(url);
		Thread.sleep(1000);

		Loginpage login = new Loginpage(driver);
		login.logintoapp();
		Thread.sleep(1000);
		Dashboardpage db = new Dashboardpage(driver);
		db.tshirtcategory();
		Thread.sleep(1000);
		Logoutpage logout = new Logoutpage(driver);
		logout.signoutfromapp();
		Thread.sleep(1000);
		driver.quit();
	}

}
