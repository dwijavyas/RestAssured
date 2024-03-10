package eCommerce;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class DeleteProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//delete product
		RestAssured.baseURI = ("https://rahulshettyacademy.com");
		
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWJhOGVjMGE4NmY4Zjc0ZGM2OGVmYmMiLCJ1c2VyRW1haWwiOiJyb251QGdtYWlsLmNvbSIsInVzZXJNb2JpbGUiOjc3ODI5Mzk5OTcsInVzZXJSb2xlIjoiY3VzdG9tZXIiLCJpYXQiOjE3MDY3MjY1MzEsImV4cCI6MTczODI4NDEzMX0.S1bZp7nO_W0jP0nxCn6KJPGioBOZCl1FZ73mf0WdCzE";
				
		String deleteResponse = given().log().all()
				.pathParam("productId", "65bacb54a86f8f74dc690f56").header("Authorization", token)
				.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().assertThat()
				.extract().response().asString();
		
		System.out.println(deleteResponse);
		
	}

}
