package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activityiphone {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.in/");

        Thread.sleep(5000);

        System.out.println("Page Title: " + driver.getTitle());

        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys("iphone 17 pro");

        driver.findElement(By.id("nav-search-submit-button"))
              .click();

        Thread.sleep(5000);

        WebElement price = driver.findElement(
                By.xpath("(//span[@class='a-price-whole'])[4]")
        );

        System.out.println("iPhone 17 Pro Price: ₹" + price.getText());

        driver.quit();
    }
}