package DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    WebDriver driver;

    @BeforeTest
    public void openchrome() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }
    @Test
    public void text() throws InterruptedException {

        WebElement click1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        click1.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        driver.switchTo().alert().accept();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");


        WebElement click2 = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        click2.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        // Thread.sleep(5000);
        System.out.println(alert.getText());
        driver.switchTo().alert().accept();

        WebElement click3 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        click3.click();
        System.out.println(alert.getText());
        driver.switchTo().alert().accept();

        WebElement click4 = driver.findElement(By.xpath("//button[@id='promtButton']"));
        click4.click();
        System.out.println(alert.getText());
        alert.sendKeys("Lathika");
        alert.accept();
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
