package basics.RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;


public class GMapsCRUD2 {
	
	public static void main(String[] args) throws IOException {
	//check if GET,PUT,POST, DELETE - API ops work using Resr Assured automation
	//instead of calling addplace method , pass the notepad file path where ur json sits
	//for this - Body() takes only string, so convert content of the notepad json file to bytes and then to string
	
	//Add address - (POST)
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String postResponse = given().log().all().queryParam("key", "qaclick123").header("content-type", "application/json")
			.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\dwija\\OneDrive\\Desktop\\REST API\\notepad json file.json"))))
	.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
	.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
	
	System.out.println(postResponse);

	//get only and change placeid attribute from the extracted response to string from json to use it further
	JsonPath js = new JsonPath(postResponse);
	String placeIdPOST = js.getString("place_id");
	
	System.out.println(placeIdPOST);
	
	
	//Update address - (PUT)
	String updatedAdd = "70 Summer walk, USA";
	
	given().log().all().queryParam("key", "qaclick123").header("content-type", "application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeIdPOST+"\",\r\n"
			+ "\"address\":\""+updatedAdd+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}").when().put("/maps/api/place/update/json").then()
	.assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
		
	//Get the address - (GET)
	String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeIdPOST)
	.when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	//get only and change address attribute from the extracted response to string from json to use it further
	JsonPath js1 = ReusableMethods.rawToJson(getResponse);
	String addressGET = js1.getString("address");
	System.out.println(addressGET);
	Assert.assertEquals(addressGET, updatedAdd);
	
	
}
}