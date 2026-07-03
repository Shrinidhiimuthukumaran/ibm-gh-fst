package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

		// TODO Auto-generated method stub

		WebDriver driver;

	    @BeforeClass
	    public void beforeClass() {
	        driver = new FirefoxDriver();
	        driver.get("https://training-support.net/webelements/target-practice");
	    }
	    
	    @Test(groups = { "HeaderTests", "ButtonTests" })
	    public void pageTitleTest() {
	        String title = driver.getTitle();
	        System.out.println("Title is: " + title);
	        Assert.assertEquals(title, "Selenium: Target Practice");
	    }
	    
	    @Test(dependsOnMethods= {"pageTitleTest"},groups= {"HeaderTests"})
	    public void headertest() {
	    	driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h3[1]"));
	    	
	    	
	    }
	  
	    
	    
	    @AfterClass
	    public void afterClass() {
	        driver.close();
	    }
	    
	

}
