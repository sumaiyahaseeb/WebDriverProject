package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {

		// step 1: Launch chrome and open simplilearn website

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// step 2: maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// step 3: get the title of the opening page and print it

		System.out.println("The title of the page is " + driver.getTitle());

		// step 4: click on the log in link on the top right corner

		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		String location = loginlink.getAttribute("href");
		System.out.println("The link will take you to" + location);

		loginlink.click();

		// step 5 : Enter the username

		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("abc@xyz.com");

		// step 6 : Enter the password

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abc@12345");

		// step 7 :Click on remember me check box
		WebElement checkbox = driver.findElement(By.className("rememberMe"));
		checkbox.click();

		// step 8 : click on login button
		WebElement loginbuttton = driver.findElement(By.name("btn_login"));
		loginbuttton.click();

		// step 9 : validate login was unsuccessful and error message is as expected

		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		String experrorMsg = "The email or password you have entered is invalid.";

		if (error.isDisplayed() && errorMsg.equals(experrorMsg)) {
			System.out.println("TC Passed");

		}

		else
			System.out.println("TC Failed");

		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links " + alllinks.size());

		for (WebElement link : alllinks) {
			System.out.println(link.getAttribute("href"));

		}
		// step 10 : close the browser

		driver.close();
	}

}
