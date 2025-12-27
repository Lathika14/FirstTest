package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadFile {
    WebDriver driver;

    @BeforeTest
    public void openchrome() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException, AWTException {
        WebElement diwnloadb = driver.findElement(By.id("downloadButton"));
        diwnloadb.click();
        Thread.sleep(5000);
        File fileLocation = new File("C:\\Users\\rajub\\Downloads");
        File[] filesss = fileLocation.listFiles();
        for (File file : filesss) {
            if (file.getName().equals("sampleFile")) {
                System.out.println("File is download successfully!");
                break;
            }
        }
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        WebElement upload = driver.findElement(By.xpath("//label[text()='Select a file']"));
        upload.click();
        Thread.sleep(3000);
        StringSelection selection = new StringSelection("C:\\Users\\rajub\\Downloads\\sampleFile.jpeg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("file upload successfully");


    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
