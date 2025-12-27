package TestNGCode;

import org.testng.annotations.Test;

public class GroupingExample{
    /* scenatio : A big basket is having a different kind os mobiles.
       let us say there are apple phone,moto, vivo and lenovo.
       I want to run tests only for vivo and moto phpnes.write a program for that.
     */
    @Test(groups = {"Apple"})
    public void apple1(){
        System.out.println("apple testing");
    }
    @Test(groups = {"Apple"})
    public void apple2(){
        System.out.println("apple testing");
    }
    @Test(groups = {"Moto"})
    public void moto1(){
        System.out.println("moto testing");
    }
    @Test(groups = {"Moto"})
    public void moto2(){
        System.out.println("moto testing");
    }
    @Test(groups = {"vivo"})
    public void vivo1(){
        System.out.println("vivo testing");
    }
    @Test(groups = {"vivo"})
    public void vivo2(){
        System.out.println("vivo testing");
    }
    @Test(groups = {"lenovo"})
    public void lenovo1(){
        System.out.println("lenovo testing");
    }
    @Test(groups = {"lenovo"})
    public void lenovo2(){
        System.out.println("lenovo testing");
    }
}
