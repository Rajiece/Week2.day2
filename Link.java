import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();
		String link = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']")).getAttribute("href");
		System.out.println("Link: "+link);
		boolean result = driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).isEnabled();
		if(result==true)
		{
			System.out.println("Link is enabled");
		}
		else
			System.out.println("Link disabled");
		//Thread.sleep(2000);
		//driver.navigate().back();
		driver.findElement(By.linkText("Go to Home Page")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
