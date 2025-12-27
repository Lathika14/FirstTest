package DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Links {
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
        WebElement Links = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Links']"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", Links);
        Thread.sleep(300);

        Links.click();
        System.out.println("✓ Links page opened");
        js.executeScript("window.scrollBy(0,400);");
//        String oldWindow = driver.getWindowHandle();
//        System.out.println("old window "+oldWindow);

        WebElement homelink=driver.findElement(By.id("simpleLink"));
        homelink.click();
//        String newWindow = driver.getWindowHandle();
//        System.out.println("first window "+newWindow);
        Set<String> windowh=driver.getWindowHandles();
        List<String> list=new ArrayList<String>(windowh);
        driver.switchTo().window(list.get(0));


        //driver.switchTo().newWindow(WindowType.TAB);


        WebElement dynamicLink=driver.findElement(By.id("dynamicLink"));
        dynamicLink.click();
//        driver.close();//a[@id='created']
        driver.switchTo().window(list.get(0));
        WebElement cr=driver.findElement(By.xpath("//a[@id='created']"));
        cr.click();

//        WebElement text=driver.findElement(By.xpath("//*[@id='linkResponse']"));
//        System.out.println(text.getText());

    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}