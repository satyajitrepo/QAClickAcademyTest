package main;

import java.util.concurrent.TimeUnit;

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
		String browser = "chrome";
		
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
			DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
			ieCap.setCapability("ignoreProtectedModeSettings", true);
			ieCap.setCapability("nativeEvents", false);
			
			driver = new InternetExplorerDriver(ieCap);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		}
		else
			System.out.println("Please select one browser.");
		
		driver.manage().window().maximize(); // for maximizing the browser
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/"); 
		
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
		
//		By by = By.id("autocomplete");
		
//		WebElement elem = driver.findElement(by);
		
//		elem.sendKeys("Hello... Good Afternoon!");
		
		
//		By by1 = By.id("openwindow");
//		WebElement elem1 = driver.findElement(by1);
//		elem1.click();
		
//		driver.findElement(By.id("openwindow")).click();
		
//		driver.findElement(By.linkText("REST API")).click();
			
//		System.out.println(driver.findElement(By.xpath("//table[@id='product']//tr[6]/td[3]")).getText());
//		
//		
//		System.out.println(driver.findElement(By.xpath("//table[@id='product']//tr[5]/td[2]")).getText());
//		System.out.println(" Tottal no. of rows : "+driver.findElements(By.xpath("//table[@id='product']//tr")).size());
		
		//driver.close(); // it will close the current page
		
		driver.findElement(By.id("name")).sendKeys("Folks");
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		driver.quit(); // it will close all the opened pages
		
	}

}
