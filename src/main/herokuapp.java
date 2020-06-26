package main;

import java.util.Iterator;
import java.util.Set;
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

public class herokuapp {

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
		else
			System.out.println("Please select one browser.");
		
		driver.manage().window().maximize(); // for maximizing the browser
		
		driver.get("https://the-internet.herokuapp.com/windows"); 
		
		driver.findElement(By.linkText("Click Here")).click();
		
		System.out.println(driver.getTitle());
		
		// Handle Multiple Windows
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		
		String lastId = "";
		while(itr.hasNext()) {
			lastId = itr.next();
			System.out.println("Iteration : "+lastId);
		}
		
		System.out.println("Last Window Id is : "+lastId);
		
		driver.switchTo().window(lastId);
		
		System.out.println(driver.getTitle());
		
		//driver.quit(); 
		
	}

}
