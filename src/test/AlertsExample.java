package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//select ok for the popup
		WebElement clickme = driver.findElement(By.id("alertButton"));
		clickme.click();
		
		Alert obj =driver.switchTo().alert();
		Thread.sleep(2000);
		obj.accept();	
		
		//dismiss the pop up or select cancel
		WebElement confirmbox = driver.findElement(By.id("confirmButton"));
		//because getting element interrupted exception we need to use scroll to find that element
		JavascriptExecutor scroll =(JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView();", confirmbox);
		confirmbox.click();
		
		 obj =driver.switchTo().alert();
		 Thread.sleep(2000);
		 obj.dismiss();
		 
		 driver.close();
	}

}
