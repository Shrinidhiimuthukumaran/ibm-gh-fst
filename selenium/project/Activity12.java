package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://training-support.net/webelements/drag-drop");

        System.out.println("Page Title: " + driver.getTitle());
        
        WebElement ball=driver.findElement(By.id("ball"));
        
        WebElement zone1=driver.findElement(By.id("dropzone1"));
        
        WebElement zone2=driver.findElement(By.id("dropzone2"));
        
        builder.clickAndHold(ball).moveToElement(zone1).pause(5000).release().build().perform();
        
        if(zone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in zone 1");
        }
        
      builder.dragAndDrop(ball,zone2).pause(5000).release().build().perform();
        
        if(zone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in zone 2");
        }
        
        driver.quit();
        

	}

}
