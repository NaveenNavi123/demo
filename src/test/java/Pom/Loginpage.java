package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	WebDriver driver;
	
	By signup=By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
	By username=By.id("email");
	By password=By.id("passwd");
	By login=By.xpath("//*[@id=\"SubmitLogin\"]/span");
 
public Loginpage(WebDriver driver2) {
	this.driver = driver2;
	}

public void logintoapp(){
	driver.findElement(signup).click();
	driver.findElement(username).sendKeys("naveen@gmail.com");
	driver.findElement(password).sendKeys("9980112373");
	driver.findElement(login).click();
}
 
}

