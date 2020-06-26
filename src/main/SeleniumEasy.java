package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumEasy {

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
		
		driver.get("https://www.spicejet.com/"); 
		
		//******************** Static Drop-down ***************************
		
		//Way-1
//		driver.findElement(By.id("select-demo")).click();
//		
//		driver.findElement(By.xpath("//option[text()='Friday']")).click();
		
		//Way - 2
		
//		Select s =new Select(driver.findElement(By.id("select-demo")));
//		
//		s.selectByIndex(6);
//		
//		s.selectByValue("Sunday");
//		
//		s.selectByVisibleText("Saturday");
		
		//******************** Dynamic Drop-down ***************************
		
		String from = " Goa (GOI)";
		String to = " Kolkata (CCU)";
		
		System.out.println(" Count before wait : "+driver.findElements(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).size());  //0
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(" Count after wait : "+driver.findElements(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).size());  //1
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[text()='"+from+"']")).click(); // 90 sec
		
		//ctl00_mainContent_ddl_originStation1_CTXT
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='"+to+"'])[2]"))).click();
		
		//driver.quit(); 
		
	}

}
