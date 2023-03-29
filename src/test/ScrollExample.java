package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//select the destination to be clicked after scrolling
		WebElement scrollto =driver.findElement(By.xpath("//h2[text()='HTML Exercises']"));
		
		Thread.sleep(3000);
		JavascriptExecutor obj =(JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", scrollto);
		
		Thread.sleep(3000);
		//scroll up
		obj.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}

}
