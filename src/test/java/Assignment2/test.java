package Assignment2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class test {
    @Test
    public void GetRequest(){

        RestAssured.baseURI = "https://reqres.in/api/";
         Response response= (Response) RestAssured.given().log().all().basePath("users")
                .header("Content-Type","application/json")
                .when()
                .get()
                .then()
                 .log().body();

        //extract().response().asString();

       // System.out.println(responseBody);
    }

    @Test
    public void PostRequest(){
// https://reqres.in/api/users/2
        RestAssured.baseURI = "https://reqres.in/api/";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        int responseCode = RestAssured.given().basePath("users")
                .when().contentType(ContentType.JSON)
                .body(body)
                .post()
                .then().extract().statusCode();

        System.out.println(responseCode);

        RestAssured.baseURI = "https://reqres.in/api/";
        String responseBody = RestAssured.given().basePath("users")
                .when().contentType(ContentType.JSON)
                .body(body)
                .post()
                .then().extract().body().asString();

        System.out.println(responseBody);
    }

    @Test
    public void PutRequest(){
        RestAssured.baseURI = "https://reqres.in/api/";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        int responseCode = RestAssured.given().basePath("users/2")
                .when().contentType(ContentType.JSON)
                .body(body)
                .put()
                .then().extract().statusCode();

        System.out.println(responseCode);

        RestAssured.baseURI = "https://reqres.in/api/";
        String responseBody = RestAssured.given().basePath("users/2")
                .when().contentType(ContentType.JSON)
                .body(body)
                .put()
                .then().extract().body().asString();

        System.out.println(responseBody);

    }

    @Test
    public void DeleteRequest(){
        RestAssured.baseURI = "https://reqres.in/api/";
        int responseCode = RestAssured.given().basePath("users/2")
                .when().contentType(ContentType.JSON)
                .delete()
                .then().extract().statusCode();

        System.out.println(responseCode);

        RestAssured.baseURI = "https://reqres.in/api/";
        String responseBody = RestAssured.given().basePath("users/2")
                .when().contentType(ContentType.XML)
                .delete()
                .then().extract().response().asString();

        System.out.println(responseBody);
    }
}
