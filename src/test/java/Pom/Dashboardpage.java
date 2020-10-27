package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Dashboardpage {
	WebDriver driver;
	
	By category=By.linkText("Women");
	By selectimage=By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
	By cart=By.xpath("//*[@id=\"add_to_cart\"]/button/span");
	By payment1=By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
	By payment2=By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	By payment3=By.name("processAddress");
	By payment4=By.name("processCarrier");
	By agreement=By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input");
	By paymode=By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
	By confirmorder=By.xpath("//*[@id=\"cart_navigation\"]/button/span");
	

public Dashboardpage(WebDriver driver) {
	this.driver = driver;
}
	
public void tshirtcategory() throws InterruptedException {

	driver.findElement(category).click();
	driver.findElement(selectimage).click();
	Thread.sleep(10000);
	driver.findElement(cart).click();
	Thread.sleep(5000);
	driver.findElement(payment1).click();
	Thread.sleep(1000);
	driver.findElement(payment2).click();
	Thread.sleep(1000);
	driver.findElement(payment3).click();

	driver.findElement(agreement).click();

	Thread.sleep(1000);
	driver.findElement(payment4).click();
	Thread.sleep(1000);
	driver.findElement(paymode).click();
	Thread.sleep(1000);
	driver.findElement(confirmorder).click();	
	System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText());	
	
}
  
}
