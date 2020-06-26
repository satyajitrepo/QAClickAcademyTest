package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
			System.out.println("Please select one browser.");
		
		driver.manage().window().maximize(); // for maximizing the browser
		
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html"); 
		
		WebElement elem1 = driver.findElement(By.xpath("//option[text()='Florida']"));
		WebElement elem2 = driver.findElement(By.xpath("//option[text()='New Jersey']"));
		WebElement elem3 = driver.findElement(By.xpath("//option[text()='New York']"));
		WebElement elem4 = driver.findElement(By.xpath("//option[text()='Washington']"));
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL)
				.moveToElement(elem1).click()
				.moveToElement(elem1).click()
				.moveToElement(elem2).click()
				.moveToElement(elem3).click()
				.moveToElement(elem4).click()
				.build().perform();
		
		driver.findElement(By.xpath("//button[text()='Get All Selected']")).click();
		
		String strExpected = "Florida,New Jersey,New York,Washington";
		
		String value = driver.findElement(By.className("getall-selected")).getText().trim();
		value = value.replace("Options selected are : ", "");
		
		// validation with TestNG
		Assert.assertEquals(value, strExpected);
		
		//driver.quit(); 
		
	}

}
