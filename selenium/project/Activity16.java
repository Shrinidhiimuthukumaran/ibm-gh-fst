package selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.*;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		
		System.out.println("page title:"+driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
		Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();
		
		select.selectByVisibleText("Two");
		System.out.println("Second option: " + select.getFirstSelectedOption().getText());
		
		
		select.selectByIndex(3);
		System.out.println("third option: " + select.getFirstSelectedOption().getText());

		
		select.selectByValue("four");
		System.out.println("fourth option: " + select.getFirstSelectedOption().getText());

		
		for(WebElement opt : options) {
            System.out.println(opt.getText());
        }
		
		driver.quit();
		

	}

}
