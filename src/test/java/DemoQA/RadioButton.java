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

public class RadioButton {

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
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Radio Button']"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
        Thread.sleep(300);

        checkbox.click();
        System.out.println("✓ Radiobutton page opened");
        WebElement clickYEs = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='custom-control-label' and @for='yesRadio']"))
        );
        js.executeScript("window.scrollBy(0, 250);");
        clickYEs.click();

        WebElement output = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='mt-3']")));
        System.out.println(output.getText());

    }

    }
