package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logoutpage {
	WebDriver driver;
	
	By signout=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");

public Logoutpage(WebDriver driver2) {
	this.driver = driver2;
	}
public void signoutfromapp() {
	driver.findElement(signout).click();
}

  
}
