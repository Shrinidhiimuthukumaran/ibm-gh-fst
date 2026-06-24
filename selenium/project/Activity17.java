package selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.*;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		
		System.out.println("page title:"+driver.getTitle());
		
		WebElement dropdown =
		        driver.findElement(By.xpath("//select[@multiple]"));

		Select select = new Select(dropdown);
		
		
		select.selectByVisibleText("HTML");
		
		for (int i = 3; i <= 5; i++) {
            select.selectByIndex(i);
        }
		
		select.selectByValue("nodejs");
		
		List<WebElement> options = select.getAllSelectedOptions();
		System.out.print("selected options:");
		
		for(WebElement opt : options) {
            System.out.println(opt.getText());
        }
		
		driver.quit();
		

	}

}
