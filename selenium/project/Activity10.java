package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
        Actions builder = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("page title:"+ driver.getTitle());
		
		WebElement cargolock=driver.findElement(By.xpath("//*[@id=\"stage\"]/div[1]/div[1]/div/h1"));
		
		WebElement cargotoml=driver.findElement(By.xpath("//*[@id=\"stage\"]/div[1]/div[2]/div/h1"));
		
		WebElement src=driver.findElement(By.xpath("//*[@id=\"stage\"]/div[1]/div[3]/div/h1"));
		
		WebElement target=driver.findElement(By.xpath("//*[@id=\"stage\"]/div[1]/div[4]/div/h1"));
		
		builder.click(cargolock).pause(1000).moveToElement(cargotoml).pause(5000).click(cargotoml).build().perform();
        
        String actionMessage = driver.findElement(By.id("result")).getText();
        
        System.out.println(actionMessage);

        
        builder.doubleClick(src).pause(3000).pause(5000).contextClick(target).pause(3000).build().perform();
       
        builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(5000).build().perform();
       
        actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);

        driver.quit();

		

	}

}
