package TestNGCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTesting {

    @Test
    public void opengoogle(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
    @Test
    public void openbing(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.bing.com");
        driver.quit();
    }
}
