package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyLogin {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("abc@xyz.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("Abc@12345");
		
		WebElement loginbuttton = driver.findElement(By.name("login"));
		loginbuttton.click();
	}

}
