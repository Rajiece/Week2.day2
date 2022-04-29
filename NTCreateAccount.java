package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTCreateAccount {
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password Using Id Locator
	 * 
	 * 3. Click on Login Button using Class Locator
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on Accounts Button
	 * 
	 * 6. Click on Create Account
	 * 
	 * 7. Select preferred currency as Indian Rupee using SelectByValue
	 * 
	 * 8. Enter the Description text as "NRI Account"
	 * 
	 * 9. Enter LocalName Field Using Xpath Locator
	 * 
	 * 10. Enter SiteName Field Using Xpath Locator
	 * 
	 * 11. Enter value for AnnualRevenue Field using Xpath Locator but class as
	  Attribute
	 * 
	
	 * 
	 * 17. Click on Create Account using Xpath Locator
	 * 
	 * 18. Get the Text of Error Message Displayed (hint: Red Texts)
             * close the browser
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		Select select = new Select(driver.findElement(By.id("currencyUomId")));
		select.selectByValue("INR");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("NRI Account");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Pleasanton");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("100000");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		System.out.println("Error Message: "+driver.findElement(By.xpath("//li[@class='errorMessage']")).getText());
		driver.close();
		}

}
