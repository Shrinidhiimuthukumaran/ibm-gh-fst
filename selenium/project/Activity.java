package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		
		WebElement searchBox=driver.findElement(By.name("q"));
		
		System.out.println("ID: " + searchBox.getAttribute("name"));
		System.out.println("NAME: " + searchBox.getAttribute("name"));
		System.out.println("CLASS: " + searchBox.getAttribute("class"));
		
		System.out.println("ARIA-LABEL: " + searchBox.getAttribute("aria-label"));
		System.out.println("TITLE: " + searchBox.getAttribute("title"));
		driver.quit();

	}

}