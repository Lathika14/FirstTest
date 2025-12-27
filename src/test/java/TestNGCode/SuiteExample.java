package TestNGCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteExample {

    //aim : open chrome and go to
    //1.google.com 2.bing.com and yahoo.comm and then close

    WebDriver driver;
    long startTime;
    long endTime;
    long totalTime;

    @BeforeSuite
    public void lunchBrowser(){
        startTime=System.currentTimeMillis();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }
    @Test
    public void google(){
        driver.get("https://www.google.com");
    }
    @Test
    public void bing(){
        driver.get("https://www.bing.com");
    }
    @Test
    public void yahoo(){
        driver.get("https://www.yahoo.com");
    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
        endTime=System.currentTimeMillis();
        totalTime=endTime-startTime;
        System.out.println("total time taken : "+totalTime);
    }

//    @Test
//    public void openGoogle(){
//        long startTime = System.currentTimeMillis();
//
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.google.com");
//        driver.quit();
//
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime-startTime;
//        System.out.println("total time taken is : " +totalTime);
//    }
//    @Test
//    public void openBing(){
//        long startTime = System.currentTimeMillis();
//
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.bing.com");
//        driver.quit();
//
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime-startTime;
//        System.out.println("total time taken is : " +totalTime);
//    }
//    @Test
//    public void openYahoo(){
//        long startTime = System.currentTimeMillis();
//
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.yahoo.com");
//        driver.quit();
//
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime-startTime;
//        System.out.println("total time taken is : " +totalTime);
//    }
}
