package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
        System.out.println("Page title: " + driver.getTitle());
        String h3text = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h3[1]")).getText();
        System.out.println(h3text);
        Color h5color = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
        System.out.println("Color as RGB: " + h5color.asRgb());
        System.out.println("Color as hexcode: " + h5color.asHex());
        String purplebutton=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/button[5]")).getDomAttribute("class");
        System.out.println("purple classes:"+purplebutton);
        String slate=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/button[6]")).getText();
        System.err.println("slate:"+slate);
        
        driver.quit();

		
	}

	
}
