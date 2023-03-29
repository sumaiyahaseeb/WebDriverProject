package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement newtab = driver.findElement(By.id("tabButton"));

		String parentwindow = driver.getWindowHandle();
		System.out.println("The parent window is " + parentwindow);
		newtab.click();

		Set<String> allwin = driver.getWindowHandles();
		String childwin = "";

		for (String win : allwin) {
			System.out.println("The window ID is " + win);

			// logic to find out child window from the set
			if (!win.equals(parentwindow)) {
				childwin = win;

			}

		}

		System.out.println("Child window is " + childwin);
		// making the driver move to child window
		driver.switchTo().window(childwin);

		WebElement childheader = driver.findElement(By.id("sampleHeading"));
		System.out.println("header in the child window is : " + childheader.getText());

		driver.close();

		// tell driver to go back to parent window

		driver.switchTo().window(parentwindow);
		WebElement newwindow = driver.findElement(By.id("windowButton"));
		newwindow.click();

		//repeat the process foe the new window because in selenium each tab is treated as a window
		//you can reuse the same set and values instead of creating new child and parent window once declared
		
		allwin = driver.getWindowHandles();
		for (String win : allwin) {
			System.out.println("the win ID is :" + win);

			// logic to find out child window from the set
			if (!win.equals(parentwindow)) {
				childwin = win;

			}
		}
		System.out.println("the child window is:" + childwin);

		driver.switchTo().window(childwin);
		childheader = driver.findElement(By.id("sampleHeading"));
		System.out.println("header in the child window is : " + childheader.getText());

		driver.quit();
	}

}
