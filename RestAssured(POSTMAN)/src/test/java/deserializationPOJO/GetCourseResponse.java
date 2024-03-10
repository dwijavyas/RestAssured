package deserializationPOJO;

public class GetCourseResponse {

	//this is parent getcourseresponse
	
	//{
	//"instructor":"RahulShetty",
	//"url":"rahulshettycademy.com",
	//"services":"projectSupport",
	//"expertise":"Automation",
	//"courses":{
		//"webAutomation":[{"courseTitle":"Selenium Webdriver Java","price":"50"},
							//{"courseTitle":"Cypress","price":"40"},
							//{"courseTitle":"Protractor","price":"40"}],
		//"api":[{"courseTitle":"Rest Assured Automation using Java","price":"50"},
				//{"courseTitle":"SoapUI Webservices testing","price":"40"}],
		//"mobile":[{"courseTitle":"Appium-Mobile Automation using Java","price":"50"}]},
	//"linkedIn":"https://www.linkedin.com/in/rahul-shetty-trainer/"}
	
	//nested json
	//POJO class for serialization/deserialization - method getters and setters
	//this class is the parent for sub json Courses and grandparent for webauto, api and mobile
	
	//return type is string for below cz direct key-value pair
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	//return type is courses class cz it courses has sub json and sub sub json
	private String linkedIn;
	private Courses Courses;
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	//return type of get set also would be the class Courses
	public deserializationPOJO.Courses getCourses() {
		return Courses;
	}
	public void setCourses(deserializationPOJO.Courses courses) {
		Courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	
}
