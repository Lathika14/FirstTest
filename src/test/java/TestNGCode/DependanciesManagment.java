package TestNGCode;

import org.testng.annotations.Test;

public class DependanciesManagment {
    @Test(enabled = true)
    public void highSchool(){
        System.out.println("High School");
    }
    @Test(dependsOnMethods = "highSchool")
    public void higherScoSchool(){
        System.out.println("Higher School");
    }
    @Test(dependsOnMethods = "higherScoSchool")
    public void CollageEngineering(){
        System.out.println("Collage Engineering");
    }
}
