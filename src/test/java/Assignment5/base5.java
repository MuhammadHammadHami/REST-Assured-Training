package Assignment5;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class base5 {
    @BeforeClass
    public static void setup() {

        baseURI = "http://3.13.86.142:3000";
        basePath = "/contacts";
    }
}
