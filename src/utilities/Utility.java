package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public static JavascriptExecutor js = null;
	public static WebDriver driver = null;
	public static String browser = null;
	public static String URL = null;
	public static int timeLimit = 0;
	public static String mainDir = System.getProperty("user.dir");

	static{
		try {
			FileInputStream fs = new FileInputStream(mainDir + "\\src\\config.properties");
			Properties prop = new Properties();
			prop.load(fs);
			browser = prop.getProperty("browser");
			URL = prop.getProperty("URL");
			timeLimit = Integer.parseInt(prop.getProperty("timeLimit"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", mainDir + "\\Resources\\chromedriver.exe");
			
			// step 1: create an object of DesiredCapabilities for chrome
			DesiredCapabilities ch = DesiredCapabilities.chrome();
			
			//step 2 : plugin desired capabilities to the object of DesiredCapabilities
			//way 1 -->
			//ch.acceptInsecureCerts();
			
			//way 2 --> add multiple capabilities to the DesiredCapabilities object
			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			// step 3: create an object of ChromeOptions
			ChromeOptions options = new ChromeOptions();
			
			// step 4: merge that DesiredCapabilities object to the ChromeOptions obejct
			options.merge(ch);
			
			// step 5: pass the newly created ChromeOptions object to the ChromeDriver
			driver = new ChromeDriver(options);
					
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", mainDir + "\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeLimit, TimeUnit.SECONDS);
		driver.get(URL);
		js = (JavascriptExecutor) driver;

		return driver;
	}

	public static void highLight(WebElement elem) {
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;'); ", elem);
	}

	public void typeText(By by, String value) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		elem.sendKeys(value);
	}

	public static void click(By by) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		try {
			takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elem.click();
	}

	public static void staticDropDown(By by, String value) throws Exception {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		Select select = new Select(elem);
		boolean flag = true;
		
		do {
			try {
				if(flag)
					select.selectByValue(value);
				else
					select.selectByVisibleText(value);
				break;
			}catch(Exception e) {
				if(flag) {
					flag = false;
					continue;
				}
				else {
					throw new Exception();
				}				
			}
			
		}while(true);		
	}

	public static void dropDown(By by, int index) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		Select select = new Select(elem);
		select.selectByIndex(index);
	}
	
	
	public static String getHiddenText(String attrVal) {
		return (String) js.executeScript("return document.getElementById(\"email\").value()");
	}
	
	public static void takeScreenshot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F:\\Resources\\screenshots\\demo.jpg"));
	}
	
	public static void colseBrowser() {
		driver.quit();
	}
}
