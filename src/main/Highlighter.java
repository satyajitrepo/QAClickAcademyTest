package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Highlighter {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		String browser = "chrome";
		String mainDir = System.getProperty("user.dir");
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", mainDir+"\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", mainDir+"\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		
	}

}
