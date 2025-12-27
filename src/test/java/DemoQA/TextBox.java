package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {
    WebDriver driver;

    @BeforeTest
    public void openchrome() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void Test() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait for page body to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Safely hide ad iframe (check if exists)
//        try {
//            js.executeScript("let ad = document.getElementById('fixedban'); if(ad){ad.style.display='none';}");
//            js.executeScript("let f = document.getElementsByTagName('iframe'); if(f.length>0){f[0].style.display='none';}");
//        } catch (Exception e) {
//            System.out.println("Ad/iframe not found. Continuing...");
//        }

        Thread.sleep(1000);  // Give time for UI to settle

        // Wait for the Elements card
        WebElement elementsCard = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']"))
        );

        // Scroll into view
        js.executeScript("arguments[0].scrollIntoView(true);", elementsCard);
        Thread.sleep(500);

        // Click the card
        elementsCard.click();
        System.out.println("✓ Successfully navigated to Elements Page");

        // Wait for menu to load
        WebElement textMenu = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Text Box']"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", textMenu);
        Thread.sleep(300);

        textMenu.click();
        System.out.println("✓ Text Box page opened");

        WebElement usna = driver.findElement(By.xpath("//input[@id='userName']"));
        usna.sendKeys("Lathika");
        System.out.println("enter the name");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("lathika@gmail.com");
        System.out.println("enter the email");

        WebElement cuA = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        cuA.sendKeys("TamilNadu");

        js.executeScript("arguments[0].scrollIntoView(true);", cuA);
        System.out.println("enter the current Address");

        WebElement PA = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        PA.sendKeys("TamilNadu");
        System.out.println("enter the Permanent Address");

        WebElement summit = driver.findElement(By.xpath("//button[@id='submit']"));
        summit.click();
        System.out.println("summit button Successfully");
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}

