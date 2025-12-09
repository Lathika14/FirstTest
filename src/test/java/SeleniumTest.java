import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
   public static void main(String[] args) throws InterruptedException {

       //System.setProperty("webdriver.chrome.driver","C:\\Browser\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.google.com");
       driver.manage().window().maximize();
       Thread.sleep(3000);
       driver.close();


    }
}
