package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox {

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

        // Wait for menu to load
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check Box']"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
        Thread.sleep(300);

        checkbox.click();
        System.out.println("✓ check box page opened");

        WebElement sc=driver.findElement(By.xpath("//button[@title='Expand all']"));
        sc.click();
        js.executeScript("window.scrollBy(0, 480);");
//
        // Click "Documents"
        WebElement documents = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Documents']")));
        documents.click();
//
        // Select "Word File.doc"
        WebElement wordFile = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Word File.doc']")));
        wordFile.click();
//
//        // Get the output message text
        WebElement output = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result")));

        String fullText = output.getText();
        System.out.print("Full message: " + fullText);

        // Extract ONLY selected item (after colon)
//        String selectedItem = fullText.replace("You have selected :", "").trim();
//        System.out.println("Selected item: " + selectedItem)
    }
}
