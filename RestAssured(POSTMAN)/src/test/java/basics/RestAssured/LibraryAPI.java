package basics.RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class LibraryAPI {

	
	@Test(dataProvider="booksData")
	public void addBook(String isbn, String aisle) {
		
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		//POST - Add Book
		String postResponse = given().log().all().header("Content-Type","application/json").body(Payload.addBookBody(isbn, aisle))
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		
		JsonPath js = ReusableMethods.rawToJson(postResponse);
		String idPostResponse = js.get("ID");
		System.out.println(idPostResponse);
		
				
		//Delete Book
		String deleteResponse = given().log().all().queryParam("ID", idPostResponse).when().delete("/Library/DeleteBook.php").then().log().all().assertThat()
		.statusCode(200).extract().response().asString();
		
		
		System.out.println(deleteResponse);
	}
	
	
	@DataProvider(name="booksData")
	public Object[][] getData() {
		
		return new Object [][] {{"whewu","3742"}, {"dkfv","2193"}, {"asdok","1021"}};
		
		
	}
}
