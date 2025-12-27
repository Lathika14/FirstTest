package ExceptionHandhing;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NoSuchElementExample {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.google.com");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        WebElement search = wait.until(ExpectedCondition.visibilityOfElementLocated(By.name("q")));
//        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
//        search.sendKeys("selenium"+ Keys.ENTER);

        driver.get("https://www.bing.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='sb_form_q']")));
       // WebElement search = driver.findElement(By.id("//textarea[@id='sb_form_q']"));
        search.sendKeys("selenium"+Keys.ENTER);

    }
}
