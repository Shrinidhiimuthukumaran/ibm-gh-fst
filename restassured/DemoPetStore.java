package restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DemoPetStore {

	@Test(priority = 1)
	public void GetPetDetails() {

		baseURI = "https://petstore.swagger.io/v2/pet/findByStatus";

	    Response response =
	            given()
	                .contentType(ContentType.JSON)
	                .queryParam("status", "sold")
	            .when()
	                .get(baseURI);

	    response.prettyPrint();

	    response.then()
	            .statusCode(200)
	            .body("[0].status", equalTo("sold"));
	}
    
 // Set Base URL
 // No need to add questions mark in the URL.
 // queryParam() will automatically add it while parsing.
 final static String ROOT_URI = "http://ip-api.com/json/{ipAddress}";

 	@Test(priority = 2)
 public void getIPInformation() {
     Response response = 
         given().contentType(ContentType.JSON) // Set headers
         // Add query parameter
         .when()
         .pathParam("ipAddress","125.219.5.94")
         .queryParam("fields", "query,country,city,timezone")
         .get(ROOT_URI); // Send GET request
     
     // Print response
     System.out.println(response.getBody().asPrettyString());
 }

}