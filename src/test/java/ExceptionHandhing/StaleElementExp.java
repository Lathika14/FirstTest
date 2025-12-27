package ExceptionHandhing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExp {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement search= driver.findElement(By.name("q"));
        search.sendKeys("selenim");
        search.clear();
    }



}
