package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {

    WebDriver driver;

    @BeforeTest
    public void openchrome() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450);");
      WebElement link= driver.findElement(By.xpath("//a[text()='Click Here for Valid Link']"));
        link.click();
        driver.navigate().back();
        WebElement link2= driver.findElement(By.xpath("//a[text()='Click Here for Broken Link']"));
        link2.click();
//        String title=driver.getTitle();
//        if(title.contains("Internet")){
//            System.out.println("the link is broken");
//        }
        driver.navigate().back();
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
