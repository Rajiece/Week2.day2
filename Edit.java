import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("text",Keys.TAB);
		String value= driver.findElement(By.xpath("(//input[@name='username'])[1]")).getAttribute("value");
		if(value.endsWith("TestLeaf"))
			System.out.println("Default value is TestLeaf");
		//driver.findElement(By.xpath("(//input[@name='username'])[1]")).sendKeys("default");
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		boolean result = driver.findElement(By.xpath("//label[@for='disabled']/following-sibling::input")).isDisplayed();
		if(result==true)
		{
			System.out.println("Element is disabled");
		}
		else
			System.out.println("Element is enabled");
		driver.close();
	}

}
