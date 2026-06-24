package selenium;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;


public class Activity21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/tabs");
		
		System.out.println("page title:"+driver.getTitle());
		
		
		System.out.println("Current tab is: " +driver.getWindowHandle());
		
		driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/button")).click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
        System.out.println("Currently open windows: " + driver.getWindowHandles());
		
		for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
		
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/div/div/div/button")));
        
		System.out.println("Current tab is: " +driver.getWindowHandle());
		
		System.out.println("page title:"+driver.getTitle());
		
        System.out.println("New Page message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());

        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/button")).click();
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
		driver.quit();
	}

}
