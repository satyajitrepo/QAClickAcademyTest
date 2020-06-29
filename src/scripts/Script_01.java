package scripts;

import org.openqa.selenium.By;

import utilities.Utility;

public class Script_01 {

	public static void main(String[] args) {
		
		Utility.getDriver();
		Utility.click(By.linkText("Demos"));
		
	}

}
