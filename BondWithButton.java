package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButton {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		System.out.println("Location: "+driver.findElement(By.xpath("//button[@id='position']")).getLocation());
		System.out.println("Style: "+driver.findElement(By.xpath("//button[@id='color']")).getAttribute("style"));
		System.out.println("Size: "+driver.findElement(By.xpath("//button[@id='size']")).getSize());
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.close();
	}

}
