package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PetStore {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    long petId;

    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

    // POST - Add Pet without ID
    @Test(priority = 1)
    public void addPet() {

        Map<String, Object> body = new HashMap<>();

        body.put("name", "Tommy");
        body.put("status", "available");

        Response response =
                given()
                    .spec(requestSpec)
                    .body(body)

                .when()
                    .post();

        response.then()
                .spec(responseSpec)
                .body("name", equalTo("Tommy"))
                .body("status", equalTo("available"))
                .log().all();

        petId = response.jsonPath().getLong("id");

        System.out.println("Generated Pet ID = " + petId);
    }

    // PUT - Update Status
    @Test(priority = 2)
    public void updatePetStatus() {

        Map<String, Object> body = new HashMap<>();

        body.put("id", petId);
        body.put("name", "Tommy");
        body.put("status", "sold");

        given()
            .spec(requestSpec)
            .body(body)

        .when()
            .put()

         .then()
            .spec(responseSpec)
            .body("id", equalTo(petId))
            .body("status", equalTo("sold"));
    }

    // GET - Verify Status Changed
    @Test(priority = 3)
    public void getPet() {

        given()
            .spec(requestSpec)
            .pathParam("petId", petId)

        .when()
            .get("/{petId}")

         .then()
            .spec(responseSpec)
            .body("id", equalTo(petId))
            .body("name", equalTo("Tommy"))
            .body("status", equalTo("sold"));
    }

    // DELETE Pet
    @Test(priority = 4)
    public void deletePet() {

        given()
            .spec(requestSpec)
            .pathParam("petId", petId)

        .when()
            .delete("/{petId}")

        .then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("message", equalTo(String.valueOf(petId)))
            .log().all();
    }

    // GET - Verify Pet Not Found
    @Test(priority = 5)
    public void verifyPetDeleted() {

        given()
            .spec(requestSpec)
            .pathParam("petId", petId)

        .when()
            .get("/{petId}")

        .then()
            .statusCode(404)
            .body("type", equalTo("error"))
            .body("message", equalTo("Pet not found"))
            .log().all();
    }
}