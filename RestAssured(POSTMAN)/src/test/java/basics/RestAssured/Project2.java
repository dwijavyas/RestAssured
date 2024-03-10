package basics.RestAssured;

import org.testng.Assert;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//complex json parse from only json response, when api has not 
		//been built by the devs - this is dummy api response
		
		//get only and change the course attribute 
		//from the extracted response to string from json to use it further
		JsonPath js = new JsonPath(Payload.APIResponse());
		
		//1. Print No of courses returned by API
		int courseCount = js.getInt("courses.size()");
		System.out.println(courseCount);
				
		//2.Print Purchase Amount
		int totalPrice = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalPrice);
		
		//3. Print Title of the first course
		String courseTitle = js.get("courses[0].title");
		System.out.println(courseTitle);
		
		//4. Print All course titles and their respective Prices
	
		for(int i=0;i<courseCount;i++) {
			
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(courseTitles);
			System.out.println(js.get("courses["+i+"].price").toString());
			
		}
		
		
		
		//5. Print no of copies sold by RPA Course
		
		System.out.println("Print no of copies sold by RPA Course");
		
		for(int i=0;i<courseCount;i++) {
			
			String courseTitles = js.get("courses["+i+"].title");
			
			if(courseTitles.equalsIgnoreCase("RPA")) {
				
				System.out.println(js.get("courses["+i+"].copies").toString());
				break;
			}
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		int sum = 0;
		
		System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
		
		int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalPurchaseAmount);
		
		for(int i=0;i<courseCount;i++) {
			
			int priceOfCourse = js.get("courses["+i+"].price");
			int copiesOfCourse = js.get("courses["+i+"].copies");
			int eachCoursePrice = priceOfCourse*copiesOfCourse;
			System.out.println(eachCoursePrice);
			sum = sum + eachCoursePrice;
		}
		
		System.out.println(sum);
		Assert.assertEquals(sum, totalPurchaseAmount);
		
	}

}
