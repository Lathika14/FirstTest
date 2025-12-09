
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.selenium.dev/");

        // Create JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        // Scroll to bottom of page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);

        // Find element and click using JavaScript
        WebElement element = driver.findElement(By.linkText("Downloads"));
        js.executeScript("arguments[0].click();", element);

        System.out.println("JavaScript executed successfully!");

        driver.quit();
    }
}

