import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BasicCode {

WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    @Test
    public void GoogleLike(){

        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);

        WebElement doubleC=driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleC).click().perform();

        WebElement rightCLick=driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightCLick).click().perform();

        WebElement clickMe=driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMe).perform();

    }

}
