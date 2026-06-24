package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/tables");

        System.out.println("Page Title: " + driver.getTitle());
        
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
        System.out.println("Number of columns: " + cols.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        
        List<WebElement> thirdrow = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"));
        System.out.println("third row:");
        for(WebElement ele:thirdrow) {
        	System.out.println(ele.getText());
        }
        
        String row2value=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]")).getText();
        
        System.out.println("2nd row 2nd column value:"+row2value);
        
        driver.quit();

	}

}
