package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    String [][] data={
            {"Admin","admin123"},//bothcrt
            {"a","admin123"},//password crt
            {"Admin","a"},//username crt
            {"a","a"}//both wrong
    };
    @DataProvider(name = "logindata")
    public String[][] logindataprovier(){
        return data;
    }

    @Test(dataProvider = "logindata")
    public void login(String user,String pass) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(user);
        WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(pass);
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
