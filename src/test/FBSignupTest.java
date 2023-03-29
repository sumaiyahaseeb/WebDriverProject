package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement signup = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signup.click();

		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));

		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));

		WebElement mobilenumber = driver.findElement(By.xpath("//input[@name='reg_email__'] "));

		WebElement newpassword = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));

		firstname.sendKeys("sumaiya");
		lastname.sendKeys("ayaz");
		mobilenumber.sendKeys("9341993982");
		newpassword.sendKeys("Sum@1234");

		// dropdown
		// print default value in drop down
		WebElement selectday = driver.findElement(By.xpath("//select[@id='day']/option[@selected='1']"));
		System.out.println(selectday.getText());

		// select desired value in drop down
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dday = new Select(day);
		dday.selectByVisibleText("11");

		WebElement selectmonth = driver.findElement(By.xpath("//select[@id='month']/option[@selected='1']"));
		System.out.println(selectmonth.getText());

		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select dmonth = new Select(month);
		dmonth.selectByVisibleText("Dec");

		WebElement selectyear = driver.findElement(By.xpath("//select[@id='year']/option[@selected='1']"));
		System.out.println(selectyear.getText());

		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select dyear = new Select(year);
		dyear.selectByVisibleText("1996");

		//print all the months in the month dropdown
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='month']/option"));
		for (WebElement months : list) {
			System.out.println(months.getText());

		}
		
//		WebElement female = driver.findElement(By.xpath("//input[@value='1' and @type='radio']"));
//		female.click();
		
		//instead of clicking directly the radio button select the radio button value which is provided as data 
		
		String gender="Female";
//		
//		String genderXpath="//label[text()='temp']";
//		
//		String newXpath =genderXpath.replace("temp", gender);
		
		
		//or simple do a concatination
		
		String easyxpath ="//label[text()='"+gender+"']";
		
		WebElement genderElem = driver.findElement(By.xpath(easyxpath));
		genderElem.click();
		
		

	}

}
