package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubAPI {

    RequestSpecification requestSpec;

    String sshKey;

    int keyId;

    @BeforeClass
    public void setup() {

        sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGxS2m5p9qjxNL9rzYZ/OmJda9NB+fYol8L7u15jG7TM mshr21202.it@rmkec.ac.in";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization", "Bearer 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")
                .addHeader("Accept", "application/vnd.github+json")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("title", "TestAPIKey_" + System.currentTimeMillis());
        requestBody.put("key", sshKey);

        Response response =

                given()
                        .spec(requestSpec)
                        .body(requestBody)

                .when()
                        .post("/user/keys");

        response.prettyPrint();

        response.then()

                .statusCode(201)

                .body("title", equalTo(response.jsonPath().getString("title")));

        keyId = response.jsonPath().getInt("id");

        System.out.println("Generated Key ID = " + keyId);
    }

    @Test(priority = 2)
    public void getSSHKey() {

        System.out.println("Using Key ID = " + keyId);

        Response response =

                given()

                        .spec(requestSpec)

                        .pathParam("keyId", keyId)

                .when()

                        .get("/user/keys/{keyId}");

        response.prettyPrint();

        response.then()

                .statusCode(200)

                .body("id", equalTo(keyId));

        Reporter.log(response.asPrettyString());
    }

    @Test(priority = 3)
    public void deleteSSHKey() {

        Response response =

                given()

                        .spec(requestSpec)

                        .pathParam("keyId", keyId)

                .when()

                        .delete("/user/keys/{keyId}");

        response.prettyPrint();

        response.then()

                .statusCode(204);

        System.out.println("SSH Key Deleted Successfully");

        Reporter.log("SSH Key Deleted Successfully");
    }

}