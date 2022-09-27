package Assignment5;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class pojo {


    @Test
    public void createEnvironmentNormalBody() {
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .when()
                .body("{\n" +
                        "    \"environment\": {\n" +
                        "        \"name\": \"EnvironmentByBody\",\n" +
                        "        \"values\": [\n" +
                        "            {\n" +
                        "                \"key\": \"baseurl\",\n" +
                        "                \"value\": \"255.2555.2555.255\",\n" +
                        "                \"enabled\": true,\n" +
                        "                \"type\": \"default\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}")
                .post(baseURI + basePath)
                .then()
                .statusCode(200)
                .log().body();
// env id = 9a0eaeff-39bf-43ab-b0e0-245090e24952, env uid = 23427049-9a0eaeff-39bf-43ab-b0e0-245090e24952

    }

    @Test
    public void createEnvironmentThMap() {
        Map<String, Object> requestHeader = new HashMap<>();
        requestHeader.put("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96");
        requestHeader.put("Content-Type", "application/json");

        Map<String, Object> head = new HashMap<>();
        Map<String, Object> env = new HashMap<>();
        List<Object> valueList = new ArrayList<>();

        Map<String, Object> values = new HashMap<>();
        values.put("key", "hashMapName");
        values.put("value", "255.255.255.255");
        values.put("enabled", true);
        values.put("type", "default");


        valueList.add(values);

        env.put("name", "EnvironmentByHash");
        env.put("values", valueList);

        head.put("environment", env);

        given()
                .headers(requestHeader)
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .when()
                .body(head)
                .post(baseURI + basePath)
                .then()
                .assertThat().statusCode(200)
                .log().body();

    }

    @Test
    public void createEnvironmentByJsonFile() throws IOException {
        byte[] file = Files.readAllBytes(Paths.get("src/test/body.json"));
        String input = new String(file);

//        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .when()
                .body(input)
                .post(baseURI + basePath)
                .then()
                .assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
                .assertThat().statusCode(200)
                .log().all();

    }

    @Test
    public void getAllEnvironments() {
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json; charset=utf-8")
                .when()
                .get(baseURI+basePath)
                .then()
                .assertThat().statusCode(200)
                .assertThat().header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().all();
    }

    @Test
    public void updateEnvironment() {
//        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json; charset=utf-8")
                .pathParam("uid", "23427049-77559a66-dc5c-4d84-90aa-0e22f100d259")
                .when()
                .body("{\n" +
                        "    \"environment\": {\n" +
                        "        \"name\": \"EnvironmentByPutMethod\",\n" +
                        "        \"values\": [\n" +
                        "            {\n" +
                        "                \"key\": \"baseurl\",\n" +
                        "                \"value\": \"255.2555.2555.255\",\n" +
                        "                \"enabled\": true,\n" +
                        "                \"type\": \"default\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}")
                .put(baseURI+basePath+"{uid}")
                .then()
                .assertThat()
                .body("environment.name", Is.is("EnvironmentByPutMethod"))
                .assertThat().statusCode(200)
                .assertThat().header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().all();
    }

    @Test
    public void deleteEnvironment() {
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .pathParam("uid", "23427049-77559a66-dc5c-4d84-90aa-0e22f100d259")
                .when()
                .delete(baseURI + basePath+"{uid}")
                .then()
                .log().body()
                .assertThat().extract().body().jsonPath().getString("environment.uid");
// env id = 9a0eaeff-39bf-43ab-b0e0-245090e24952, env uid = 23427049-9a0eaeff-39bf-43ab-b0e0-245090e24952

    }

    @Test
    public void getEnvironmentById() {
        Response response = getRequese();
        String contentType = response.getContentType();
        int statusCode = response.getStatusCode();


        Allure.step(contentType);


        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(contentType,"application/json; charset=utf-8");

    }

    public Response getRequese(){
        Response response = (Response) given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json; charset=utf-8")
                .pathParam("uid", "23427049-f050eb00-b3ca-4e0d-aeb8-d9a0d2c1b435")
                .when()
                .get(baseURI+basePath+"{uid}")
                .then()
//                .assertThat().body("environment.name", Is.is("EnvironmentByBody"))
//                .assertThat().statusCode(200)
//                .assertThat().header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().body().extract().response();
        return response;
    }


}
