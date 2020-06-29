package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.Utility;

public class Script_02 {

	public static void main(String[] args) {
		
		WebDriver driver = Utility.getDriver();
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//div[@id='draggable']/p")).getText());
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		driver.switchTo().defaultContent();
		//driver.switchTo().parentFrame();
	}
	
}
