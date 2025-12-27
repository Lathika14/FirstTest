package TestNGCode;

import org.testng.annotations.Test;

public class SkipTestCase {
    @Test(priority = 1)
    public void startTheCar(){
        System.out.println("start the car");
    }
    @Test(priority = 6,enabled = false)
    public void turnTheMusic(){
        System.out.println(("turn on music"));
    }
    @Test(priority = 2)
    public void putFirstGear(){
        System.out.println("First gear");
    }
    @Test(priority = 3)
    public void putScoundGear(){
        System.out.println("ScoundGear");
    }
    @Test(priority = 4)
    public void putThirdGear(){
        System.out.println("Third gear");
    }
    @Test(priority = 5)
    public void putFourGear(){
        System.out.println("four gear");
    }
}
