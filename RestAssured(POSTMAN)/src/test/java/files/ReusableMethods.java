package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJson(String getResponse) {
		
		JsonPath js1 = new JsonPath(getResponse);
		return js1;
		
	}

}
