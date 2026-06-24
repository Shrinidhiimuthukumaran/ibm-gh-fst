package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.*;

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("page title:"+driver.getTitle());
		
		driver.findElement(By.id("simple")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		Alert alert = driver.switchTo().alert();
		
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		String message=driver.findElement(By.id("result")).getText();
		
		System.out.println("result:"+message);
		
		driver.quit();
		

	}

}
