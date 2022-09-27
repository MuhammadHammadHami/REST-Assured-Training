package Assignment5;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class pojo extends base5 {


//    @Test
//    public void getEnvironmentById() {
//        Response response = getRequese();
//        String contentType = response.getContentType();
//        int statusCode = response.getStatusCode();
//
//
//        Allure.step(contentType);
//
//
//        Assert.assertEquals(statusCode,200);
//        Assert.assertEquals(contentType,"application/json; charset=utf-8");
//
//    }
//
//    public Response getRequese(){
//        Response response = (Response) given()
//                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
//                .header("Content-Type", "application/json; charset=utf-8")
//                .pathParam("uid", "23427049-f050eb00-b3ca-4e0d-aeb8-d9a0d2c1b435")
//                .when()
//                .get(baseURI+basePath+"{uid}")
//                .then()
////                .assertThat().body("environment.name", Is.is("EnvironmentByBody"))
////                .assertThat().statusCode(200)
////                .assertThat().header("Content-Type",equalTo("application/json; charset=utf-8"))
//                .log().body().extract().response();
//        return response;
//    }

    @Test
    public void getRequest(){

        Response req = RestAssured
                .given()
                .baseUri(baseURI)
                .basePath(basePath+"/6332d116e48c43062f42aca5")
//                .pathParam("_id","/6332d116e48c43062f42aca5")
                .contentType(ContentType.JSON)
                .get();



        userList responseBody = req.body().as(userList.class);
        System.out.println(responseBody.getFirstName());
        System.out.println(responseBody.getLastName());
        System.out.println(responseBody.getEmail());

    }

    @Test
    public void postRequest(){

        createUser body = new createUser();
        body.setName("Hammad");
        body.setJob("Tester");


        Response req = RestAssured
                .given()
                .baseUri(baseURI)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .body(body)
                .post();

        createUser responseBody = req.body().as(createUser.class);
        System.out.println(responseBody.getName());
        System.out.println(responseBody.getJob());

    }

}
