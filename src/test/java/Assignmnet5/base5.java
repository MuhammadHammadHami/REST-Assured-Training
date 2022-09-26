package Assignmnet5;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class base5 {
    @BeforeClass
    public static void setup(){
        baseURI = "https://api.getpostman.com/";
        basePath = "environments";
    }
}