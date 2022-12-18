package Assignmnet3;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class postWithHeadersAndBody extends Assignmnet3.base {

    @Test
    public void createWorkSpace() {
        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .when()
                .body("{\n" +
                        "    \"workspace\": {\n" +
                        "        \"name\": \"HammadWorkSpaceNew\",\n" +
                        "        \"description\": \"This is a demo workspace\",\n" +
                        "        \"type\": \"personal\"\n" +
                        "    }\n" +
                        "}")
                .post(baseURI + "workspaces")
                .then()
                .log().body();
    }

    @Test
    public void createEnvironmentNormalBody() {
        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .when()
                .body("{\n" +
                        "    \"environment\": {\n" +
                        "        \"name\": \"HammadEnvironment\",\n" +
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
                .post(baseURI + "environments")
                .then()
                .log().body();
// env id = 9a0eaeff-39bf-43ab-b0e0-245090e24952, env uid = 23427049-9a0eaeff-39bf-43ab-b0e0-245090e24952

    }

    @Test
    public void createEnvironmentThMap() {
//        baseURI = "https://api.getpostman.com/";
        Map<String, Object> requestHeader = new HashMap<>();
        requestHeader.put("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96");
        requestHeader.put("Content-Type", "application/json");

        Map<String, Object> head = new HashMap<>();
        Map<String, Object> env = new HashMap<>();
        //Map<String,List> valuesArray = new HashMap<>();
        List<Object> valueList = new ArrayList<>();

        Map<String, Object> values = new HashMap<>();
        values.put("key", "hashMapName");
        values.put("value", "255.255.255.255");
        values.put("enabled", true);
        values.put("type", "default");


        valueList.add(values);
        //valuesArray.put("values", valueList);

        env.put("name", "HammadEnvironmentHash");
        env.put("values", valueList);

        head.put("environment", env);

        given()
                .headers(requestHeader)
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .when()
                .body(head)
                .post(baseURI + basePath)
                .then()
                .log().body();
//
//        {
//            "environment": {
//            "id": "95aae017-5932-46f2-8411-723dcb49bf1b",
//                    "name": "HammadEnvironmentHash",
//                    "uid": "23427049-95aae017-5932-46f2-8411-723dcb49bf1b"
//        }
//        }


// env id = 9a0eaeff-39bf-43ab-b0e0-245090e24952, env uid = 23427049-9a0eaeff-39bf-43ab-b0e0-245090e24952

    }

    @Test
    public void createEnvironmentByJsonFile() throws IOException {
        byte[] file = Files.readAllBytes(Paths.get("src/test/body.json"));
        String input = new String(file);

        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .when()
                .body(input)
                .post(baseURI + "environments")
                .then()
                .log().body();

    }

    @Test
    public void updateEnvironment() {
//        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "text/plain")
                .pathParam("uid", "23427049-9a0eaeff-39bf-43ab-b0e0-245090e24952")
                .when()
                .body("{\n" +
                        "    \"environment\": {\n" +
                        "        \"name\": \"HammadEnvironmentUpdateNew\",\n" +
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
                .put(baseURI+basePath+"/{uid}")
                .then()
                .log().body();
    }

    @Test
    public void deleteEnvironment() {
        baseURI = "https://api.getpostman.com/";
        given()
                .header("X-Api-Key", "PMAK-632aba8d48f28a7ef851d9b7-48186fb26e5ef9e984d6f778271e80fd96")
                .header("Content-Type", "application/json")
                .queryParam("workspace", "201f8f46-1db4-4b4d-b1b3-7ba64782fa32")
                .pathParam("uid", "9a0eaeff-39bf-43ab-b0e0-245090e24952")
                .when()
                .delete(baseURI + "environments/{uid}")
                .then()
                .log().body();
// env id = 9a0eaeff-39bf-43ab-b0e0-245090e24952, env uid = 23427049-9a0eaeff-39bf-43ab-b0e0-245090e24952

    }


}
