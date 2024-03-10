package deserializationPOJO;

import static io.restassured.RestAssured.given;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

//Deserialization
public class OAuth {

		public static void main(String[] args){

			//this is array which is static
		String[] a = {"Selenium Webdriver Java","Cypress","Protractor"};

		String response =given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		                        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
		                        .formParams("scope", "trust").when().log().all()
		                        .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");

		System.out.println(accessToken);

		GetCourseResponse gcr=given().queryParams("access_token", accessToken).when().log().all().
				get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourseResponse.class);

		System.out.println(gcr.getInstructor());
		System.out.println(gcr.getLinkedIn());
		
		//find a specific course title and then extract its price
		System.out.println(gcr.getCourses().getApi().get(1).getCourseTitle());
		
		//or use for loop to iterate through all the courses when the index is not fixed
		List<Api> apiCourses = gcr.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++) {
			
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")){
				
				System.out.println(apiCourses.get(i).getPrice());
				
			}
			
		}
		
		//get all course titles under web auto
		List<WebAutomation> waCourses = gcr.getCourses().getWebAutomation();
		for(int i=0;i<waCourses.size();i++) {
			
			System.out.println(waCourses.get(i).getCourseTitle());
		}
		
		//compare the actual wa course titles with the expected
		//this is array list
		ArrayList<String> b = new ArrayList<String>();
				
		List<WebAutomation> waCourses1 = gcr.getCourses().getWebAutomation();
		for(int i=0;i<waCourses1.size();i++) {
			
			b.add(waCourses1.get(i).getCourseTitle());
		}
		
		//convert the static array 'a' into dynamic array list 'expectedCourses'
		List<String> expectedCourses = Arrays.asList(a);
		
		Assert.assertTrue(b.equals(expectedCourses));
		
		
		
	}

}
