package serializationPOJO;

import java.util.List;

public class SetRequestBody {

	//using serialization, dont sent the json body request directly in code
	//use java objects and set attribute values and pass the java object in the body()
	private String website;
	private String phone_number;
	private String address;
	private String language;
	private int accuracy;
	private SetLocationBody location;
	private List<String> types;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public SetLocationBody getLocation() {
		return location;
	}
	public void setLocation(SetLocationBody location) {
		this.location = location;
	}
	public List<String> getType() {
		return types;
	}
	public void setType(List<String> types) {
		this.types = types;
	}
	
	
}
