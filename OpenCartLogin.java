package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartLogin {

	public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://www.opencart.com/index.php?route=account/register");
	
	driver.manage().window().maximize();
	
	driver.findElement(By.id("input-firstname")).sendKeys("Chrystal");

	driver.findElement(By.id("input-lastname")).sendKeys("Tester");
	
	driver.findElement(By.id("input-country")).sendKeys("India");
	
	driver.close();
	}

}
