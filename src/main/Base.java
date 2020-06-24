package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		String browser = "ie";
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\Resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
			System.out.println("Please select one browser.");
		
		driver.manage().window().maximize(); // for maximizing the browser
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/"); 
		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
		
		By by = By.id("autocomplete");
		
		WebElement elem = driver.findElement(by);
		
		elem.sendKeys("Hello... Good Afternoon!");
		
		
//		By by1 = By.id("openwindow");
//		WebElement elem1 = driver.findElement(by1);
//		elem1.click();
		
		driver.findElement(By.id("openwindow")).click();
		
		driver.findElement(By.linkText("REST API")).click();
			
		//driver.close(); // it will close the current page
		driver.quit(); // it will close all the opened pages
		
	}

}
