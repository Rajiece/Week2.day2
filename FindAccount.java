package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAccount {
	
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
	 * 6. Click on Find Accounts
	 * 
	 * 7. Enter AccountName as "Credit Limited Account" 
	 *  
	 * 8. Click on Find Accounts using xpath Locator
	 * 
	 * 9. Click on the edit Button
	 * 
	 * 10. Get the Text of Account Name and verify 
	 *  
	 * 11. Get the Text of Description
	 * 
	 * 12. Get the title of the page and verify it.
	 */


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.xpath("//a[text()='Find Accounts']")).click();
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys("Credit Limited Account");
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//driver.findElement(By.linkText("accountlimit100")).click();
		driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
		String name = driver.findElement(By.xpath("//input[@id='accountName']")).getAttribute("value");
		System.out.println("Name: "+name);
		if(name.equals("Credit Limited Account"))
		{
			System.out.println("Account name matched");
		}
		else 
			System.out.println("No match found");
		System.out.println("Description: "+driver.findElement(By.xpath("//textarea[@name='description']")).getText());
		String title = driver.getTitle();
		if(title.equals("Edit Account | opentaps CRM"))
		{
			System.out.println("Title matched");
		}
		else 
			System.out.println("No match found");
		driver.close();
}


}
