package TestNGCode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsExample {
    String name="lathika";
    boolean value = false;

    @Test
    public void checkequal(){
//        if(name.equals("lathika")){System.out.println("name is equal");}
//        else{System.out.println("name is not equal");}
        Assert.assertNotEquals(name, "Lathika");
        Assert.assertEquals(name,"lathika");
        Assert.assertFalse(value,"this is not ture");
    }
}
