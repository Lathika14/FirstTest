package TestNGCode;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class ParameterizationExample {
    @Test
    @Parameters("Name")
    public void Printname(String name){
        System.out.println(" the name is : "+name);
    }
}
