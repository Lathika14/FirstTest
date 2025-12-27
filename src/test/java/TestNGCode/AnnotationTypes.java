package TestNGCode;

import org.testng.annotations.*;

public class AnnotationTypes {
    @Test
    public void test(){
        System.out.println("In Test");
    }
    @Test
    public void test2(){
        System.out.println("in test 2");
    }
    @BeforeMethod
    public void BeforMethod(){
        System.out.println("In before method");
    }
    @AfterMethod
    public void AfterMethos(){
        System.out.println("In after method");
    }
    @BeforeClass
    public void BeforClass(){
        System.out.println("In before cls");
    }
    @AfterClass
    public void AfterCls(){
        System.out.println("In after cls");
    }
    @BeforeTest
    public void BefotTest(){
        System.out.println("In before test");
    }
    @AfterTest
    public void Aftertest(){
        System.out.println("In after test");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("In before suite");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("In after suite");
    }
}
