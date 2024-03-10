package serializationPOJO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//serialization using GMaps API

public class Main {
	
	public static void main(String[] args) {
		
	//rest assured will convert the java object into json - put that java object in the body
	SetRequestBody p = new SetRequestBody();
	p.setAccuracy(50);
	p.setAddress("29, side layout, cohen 09");
	p.setLanguage("French-IN");
	p.setName("Frontline house");
	p.setPhone_number("(+91) 983 893 3937");
	p.setWebsite("http://google.com");
	List<String> myList = new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	p.setType(myList);
	SetLocationBody l = new SetLocationBody();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
		
	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
	.setContentType(ContentType.JSON).build();
		
	ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	//Add Place - POST
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	RequestSpecification res = given().log().all().spec(req)
			.body(p);
	
	Response response = res.when().post("/maps/api/place/add/json")
			.then().log().all().assertThat().spec(resSpec).extract().response();
	
	String responseString = response.asString();
	System.out.println(responseString);

	

}}
