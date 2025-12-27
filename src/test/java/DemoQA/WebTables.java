package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTables {
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
        WebElement webtable = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Web Tables']"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", webtable);
        Thread.sleep(300);

        webtable.click();
        System.out.println("✓ WebTable page opened");

        WebElement add = driver.findElement(By.id("addNewRecordButton"));
        add.click();
        WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstname.sendKeys("lathika");
        System.out.println("Enter the name");
        WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastname.sendKeys("S");
        System.out.println("Enter the lastname");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("Slathika@gmail.com");
        System.out.println("Enter the email");
        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.sendKeys("22");
        System.out.println("Enter the age");
        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.sendKeys("500000");
        System.out.println("Enter the salary");
        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.sendKeys("Testing");
        System.out.println("Enter the dept");
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
        System.out.println("summit successfully");
//        JavascriptExecutor j = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");

        WebElement table = driver.findElement(By.xpath("//div[@class='rt-table']"));

        String tableText = table.getText();

        if(tableText.contains("lathika")) {
            System.out.println("✓ Record added: 'lathika' is present in the table");
        } else {
            System.out.println("✗ Record NOT found in the table");
        }
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
