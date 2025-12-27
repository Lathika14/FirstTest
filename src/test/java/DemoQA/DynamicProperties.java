package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicProperties {

    WebDriver driver;

    @BeforeTest
    public void openchrome() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement enablebtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        System.out.println("enable button is enabled");

        WebElement color=driver.findElement(By.id("colorChange"));
        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class","text-danger"));
        System.out.println("color changed "+color.getCssValue("color"));

        WebElement visiblebtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("visibleAfter")));
        System.out.println(visiblebtn.getAccessibleName());

    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
