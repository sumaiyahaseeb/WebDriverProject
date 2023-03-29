package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//finding no of rows in the table
		List<WebElement> rows =driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println(rows.size());
		
		//finding no of columns in the table
		List<WebElement> columns =driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println(columns.size());
		
		//finding the data in 3rd row 1st column
		WebElement data =driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println(data.getText());
		
		//iterating through rows and trying to print data using 3 columns
		
		for(int i=2;i<=rows.size();i++) {
			List<WebElement> list =driver.findElements(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td"));
			
			System.out.println(list.get(0).getText() +" "+list.get(1).getText()+" "+list.get(2).getText());
			
		}
		
	}

}
