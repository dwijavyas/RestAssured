package eCommerce;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainProductCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//Login - create session token
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		
		//serialization for setting (set) body input
		SetLoginRequest login = new SetLoginRequest();
		login.setUserEmail("ronu@gmail.com");
		login.setUserPassword("Hello@123");
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(login);
		
		//deserialization for getting (get) response
		GetLoginResponse res = reqLogin.when().post("/api/ecom/auth/login").then().log().all().statusCode(200).extract()
				.response().as(GetLoginResponse.class);
		
		String token = res.getToken();
		String userId = res.getUserId();
		System.out.println(res.getMessage());
		
//Create/Add Product	
		RequestSpecification req1 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addHeader("Authorization", token).build();
		
		RequestSpecification reqAddProd = given().log().all().spec(req1).param("productName", "abc").param("productAddedBy", userId)
		.param("productCategory", "electronics").param("productSubCategory", "photography")
		.param("productPrice", "110").param("productDescription", "Addias")
		.param("productFor", "unisex").multiPart("productImage", new File("C://Users//dwija//Downloads//camera.jpeg"));
		
		String res1 = reqAddProd.when().post("/api/ecom/product/add-product").then().log().all().statusCode(201)
				.extract()
				.response().asString();
		
		//using jsonPath
		JsonPath js = new JsonPath(res1);
		String prodId = js.get("productId");
		System.out.println(prodId);
		
		
//Add Product to cart/create order
		RequestSpecification req2 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", token).build();
		
		//serialization for body input
		SetSubCreateOrderRequest subOrders = new SetSubCreateOrderRequest();
		subOrders.setCountry("India");
		subOrders.setProductOrderedId(prodId);
		
		List<SetSubCreateOrderRequest> orders = new ArrayList<SetSubCreateOrderRequest>();
		orders.add(subOrders);
		
		RequestSpecification reqCreateOrder = given().log().all().spec(req2).body(orders);
		
		String res2 = 
				reqCreateOrder.when().post("/api/ecom/order/create-order").then().log().all().extract()
				.response().asString();
		
		
		System.out.println(res2);
	
//delete 	
		String deleteResponse = given().log().all()
				.pathParam("productId", prodId).header("Authorization", token)
				.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().assertThat()
				.extract().response().asString();
		
		System.out.println(deleteResponse);
		
	}
		
	}


