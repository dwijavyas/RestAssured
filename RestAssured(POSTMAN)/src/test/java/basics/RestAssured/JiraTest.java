package basics.RestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import files.ReusableMethods;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI = "http://localhost:8080";
		
		//create session - POST
		SessionFilter session = new SessionFilter();
		
		String createSessionResp = given().header("Content-Type","application/json")
				.body("{ \"username\": \"dwija21\", \"password\": \"Ronak2294!\" }").filter(session)
		.when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
		
		//create issue - POST
		
		/*
		 * String createIssueResp =
		 * given().header("Content-Type","application/json").body("  {\r\n" +
		 * "  \"fields\": {\r\n" + "        \"project\": {\r\n" +
		 * "            \"key\": \"RAS\"\r\n" + "        },\r\n" +
		 * "        \"summary\": \"creating issue 2 from eclipse\",\r\n" +
		 * "        \"issuetype\": {\r\n" + "            \"name\": \"Story\"\r\n" +
		 * "        },\r\n" + "        \"reporter\": {\r\n" +
		 * "            \"name\": \"dwija21\"\r\n" + "        }\r\n" + "  }\r\n" +
		 * "  }").filter(session).when().post("/rest/api/2/issue").then().log().all().
		 * statusCode(201).extract().response().asString();
		 * 
		 * JsonPath js = ReusableMethods.rawToJson(createIssueResp); String issueID =
		 * js.get("id"); System.out.println(issueID);
		 */
		
		//add comment - POST
		
		
		String comment = "Hi I am commenting from REST API - Eclipse";
		String addCommentResp = given().pathParam("key", "10009").header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \""+comment+",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201).extract()
				.response().asString();
		
		JsonPath js2 = ReusableMethods.rawToJson(addCommentResp);
		String commentID = js2.get("id");
		
				
		//add attachment - POST
		
		given().pathParam("key", "10009").header("X-Atlassian-Token","no-check").filter(session).header("Content-Type","multipart/form-data")
		.multiPart("file", new File("C:\\Users\\dwija\\Documents\\Eclipse IDE\\eclipse-java-2020-09-R-win32-x86_64\\RestAssured(POSTMAN)\\jira.txt")).when()
		.post("/rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		
		//Get issue - GET
		String getIssueResp = given().filter(session).pathParam("key","10009").queryParam("fields", "comment")
				.when().get("/rest/api/2/issue/{key}").then().log().all().statusCode(200)
		.extract().response().asString();
		
		System.out.println(getIssueResp);
		
		JsonPath js3 = ReusableMethods.rawToJson(getIssueResp);
		int commentCount = js3.getInt("fields.comment.comments.size()");
		
		for(int i=0;i<commentCount;i++) {
			
			String stringID= js3.get("fields.comment.comments["+i+"].id").toString();
			Assert.assertEquals(stringID,commentID);
			String stringBody=js3.get("fields.comment.comments["+i+"].body").toString();
			Assert.assertEquals(stringBody,comment);
		}
		
		
	}

}
